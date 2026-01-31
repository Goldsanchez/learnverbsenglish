package com.goldsanchez.learnverbsenglish.presentation

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldsanchez.learnverbsenglish.data.AuthRepository
import com.goldsanchez.learnverbsenglish.data.ProgressRepository
import com.goldsanchez.learnverbsenglish.data.RevenueRepository
import com.goldsanchez.learnverbsenglish.data.VerbRepository
import com.goldsanchez.learnverbsenglish.data.VerbRepositoryImpl
import com.goldsanchez.learnverbsenglish.domain.model.Verb
import com.google.firebase.auth.FirebaseUser
import com.revenuecat.purchases.Package
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class IrregularVerbViewModel(
    private val repository: VerbRepository = VerbRepositoryImpl(),
    private val revenueRepository: RevenueRepository,
    private val authRepository: AuthRepository,
    private val progressRepository: ProgressRepository
) : ViewModel() {
    
    var searchQuery by mutableStateOf("")
        private set

    val verbs: List<Verb> = repository.getVerbs()

    val filteredVerbs: List<Verb>
        get() = verbs.filter {
            it.infinitive.contains(searchQuery, ignoreCase = true) ||
            it.translation.contains(searchQuery, ignoreCase = true)
        }

    val currentUser: StateFlow<FirebaseUser?> = authRepository.currentUser
    val learnedVerbs: StateFlow<Set<String>> = progressRepository.learnedVerbs

    private val _isDebugPremium = MutableStateFlow(false)
    val isAdsRemoved: StateFlow<Boolean> = revenueRepository.isAdsRemoved
        .combine(_isDebugPremium) { real, debug -> real || debug }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }

    fun toggleLearned(verbId: String) {
        // CORRECCIÓN: Permitimos que userId sea nulo para guardar localmente
        val userId = authRepository.currentUser.value?.uid 
        viewModelScope.launch {
            progressRepository.toggleVerbProgress(userId, verbId)
        }
    }

    fun getVerbByIndex(index: Int): Verb? {
        return if (index in verbs.indices) verbs[index] else null
    }

    fun getTotalVerbs(): Int = verbs.size

    fun getOfferings(onResult: (List<Package>) -> Unit) {
        revenueRepository.getOfferings(onResult)
    }

    fun purchasePackage(activity: Activity, packageToPurchase: Package) {
        revenueRepository.purchasePackage(activity, packageToPurchase) { success -> }
    }

    fun signOut() {
        authRepository.signOut()
    }
    
    fun toggleDebugPremium() {
        _isDebugPremium.value = !_isDebugPremium.value
    }
}
