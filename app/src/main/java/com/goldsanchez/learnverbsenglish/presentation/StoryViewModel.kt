package com.goldsanchez.learnverbsenglish.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldsanchez.learnverbsenglish.data.AuthRepository
import com.goldsanchez.learnverbsenglish.data.ProgressRepository
import com.goldsanchez.learnverbsenglish.data.StoryRepository
import com.goldsanchez.learnverbsenglish.data.StoryRepositoryImpl
import com.goldsanchez.learnverbsenglish.domain.model.Story
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StoryViewModel(
    private val repository: StoryRepository = StoryRepositoryImpl(),
    private val progressRepository: ProgressRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    val stories: List<Story> = repository.getStories()
    val completedStories: StateFlow<Set<String>> = progressRepository.completedStories

    fun getStoryById(id: String): Story? {
        return repository.getStoryById(id)
    }

    fun toggleStoryProgress(storyId: String) {
        val userId = authRepository.currentUser.value?.uid
        viewModelScope.launch {
            progressRepository.toggleStoryProgress(userId, storyId)
        }
    }
}
