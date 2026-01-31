package com.goldsanchez.learnverbsenglish.data

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import android.util.Log

class ProgressRepository(context: Context) {
    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("users_progress")
    private val prefs = context.getSharedPreferences("user_progress_prefs", Context.MODE_PRIVATE)

    private val _learnedVerbs = MutableStateFlow<Set<String>>(emptySet())
    val learnedVerbs: StateFlow<Set<String>> = _learnedVerbs.asStateFlow()

    private val _completedStories = MutableStateFlow<Set<String>>(emptySet())
    val completedStories: StateFlow<Set<String>> = _completedStories.asStateFlow()

    init {
        _learnedVerbs.value = prefs.getStringSet("learned_ids", emptySet()) ?: emptySet()
        _completedStories.value = prefs.getStringSet("completed_stories", emptySet()) ?: emptySet()
    }

    suspend fun fetchProgress(userId: String) {
        try {
            val document = collection.document(userId).get().await()
            
            val cloudVerbs = document.get("learned_ids") as? List<String> ?: emptyList()
            updateVerbsState((_learnedVerbs.value + cloudVerbs).toSet())

            val cloudStories = document.get("completed_stories") as? List<String> ?: emptyList()
            updateStoriesState((_completedStories.value + cloudStories).toSet())
            
        } catch (e: Exception) {
            Log.e("ProgressRepo", "Error fetching cloud progress", e)
        }
    }

    suspend fun toggleVerbProgress(userId: String?, verbId: String) {
        val currentSet = _learnedVerbs.value.toMutableSet()
        if (currentSet.contains(verbId)) currentSet.remove(verbId) else currentSet.add(verbId)
        
        val newSet = currentSet.toSet()
        updateVerbsState(newSet)
        syncWithCloud(userId, "learned_ids", newSet.toList())
    }

    suspend fun toggleStoryProgress(userId: String?, storyId: String) {
        val currentSet = _completedStories.value.toMutableSet()
        if (currentSet.contains(storyId)) {
            currentSet.remove(storyId)
        } else {
            currentSet.add(storyId)
        }
        val newSet = currentSet.toSet()
        updateStoriesState(newSet)
        syncWithCloud(userId, "completed_stories", newSet.toList())
    }

    private fun updateVerbsState(newSet: Set<String>) {
        _learnedVerbs.value = newSet
        prefs.edit().putStringSet("learned_ids", newSet).apply()
    }

    private fun updateStoriesState(newSet: Set<String>) {
        _completedStories.value = newSet
        prefs.edit().putStringSet("completed_stories", newSet).apply()
    }

    private suspend fun syncWithCloud(userId: String?, field: String, list: List<String>) {
        if (userId != null) {
            try {
                collection.document(userId).update(field, list).await()
            } catch (e: Exception) {
                collection.document(userId).set(mapOf(field to list), com.google.firebase.firestore.SetOptions.merge())
            }
        }
    }

    fun clearProgress() {
        _learnedVerbs.value = emptySet()
        _completedStories.value = emptySet()
        prefs.edit().clear().apply()
    }
}
