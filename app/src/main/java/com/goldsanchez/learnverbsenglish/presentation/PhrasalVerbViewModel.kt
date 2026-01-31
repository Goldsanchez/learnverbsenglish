package com.goldsanchez.learnverbsenglish.presentation

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldsanchez.learnverbsenglish.data.PhrasalVerbRepository
import com.goldsanchez.learnverbsenglish.data.PhrasalVerbRepositoryImpl
import com.goldsanchez.learnverbsenglish.data.RevenueRepository
import com.goldsanchez.learnverbsenglish.domain.model.PhrasalVerb
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class PhrasalVerbViewModel(
    private val repository: PhrasalVerbRepository = PhrasalVerbRepositoryImpl(),
    private val revenueRepository: RevenueRepository
) : ViewModel() {
    
    var searchQuery by mutableStateOf("")
        private set

    val phrasalVerbs: List<PhrasalVerb> = repository.getPhrasalVerbs()

    val filteredVerbs: List<PhrasalVerb>
        get() = phrasalVerbs.filter {
            it.verb.contains(searchQuery, ignoreCase = true) ||
            it.translation.contains(searchQuery, ignoreCase = true)
        }

    // Ads State from RevenueCat
    private val _isDebugPremium = MutableStateFlow(false)
    val isAdsRemoved: StateFlow<Boolean> = revenueRepository.isAdsRemoved
        .combine(_isDebugPremium) { real, debug -> real || debug }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }

    fun getVerbByIndex(index: Int): PhrasalVerb? {
        return if (index in phrasalVerbs.indices) phrasalVerbs[index] else null
    }

    fun getTotalVerbs(): Int = phrasalVerbs.size

    fun toggleDebugPremium() {
        _isDebugPremium.value = !_isDebugPremium.value
    }
}
