package com.goldsanchez.learnverbsenglish.presentation

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldsanchez.learnverbsenglish.data.BillingRepository
import com.goldsanchez.learnverbsenglish.data.VerbRepository
import com.goldsanchez.learnverbsenglish.data.VerbRepositoryImpl
import com.goldsanchez.learnverbsenglish.domain.model.Verb
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class VerbViewModel(
    private val repository: VerbRepository = VerbRepositoryImpl(),
    private val billingRepository: BillingRepository
) : ViewModel() {
    var searchQuery by mutableStateOf("")
        private set

    val verbs: List<Verb> = repository.getVerbs()

    val filteredVerbs: List<Verb>
        get() = verbs.filter {
            it.infinitive.contains(searchQuery, ignoreCase = true) ||
            it.translation.contains(searchQuery, ignoreCase = true)
        }

    // Variable para pruebas manuales (Ponla en true para simular Premium)
    private val _isDebugPremium = MutableStateFlow(false)

    // Combinamos el estado real de Google Play con nuestra variable de depuración
    val isAdsRemoved: StateFlow<Boolean> = billingRepository.isAdsRemoved
        .combine(_isDebugPremium) { real, debug -> real || debug }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }

    fun getVerbByIndex(index: Int): Verb? {
        return if (index in verbs.indices) verbs[index] else null
    }

    fun getTotalVerbs(): Int = verbs.size

    fun removeAds(activity: Activity, productId: String) {
        billingRepository.launchBillingFlow(activity, productId)
    }
    
    // Función para activar el modo premium de prueba (puedes llamarla desde un botón oculto)
    fun toggleDebugPremium() {
        _isDebugPremium.value = !_isDebugPremium.value
    }
}
