package com.goldsanchez.learnverbsenglish.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldsanchez.learnverbsenglish.data.AuthRepository
import com.goldsanchez.learnverbsenglish.data.PhrasalVerbRepository
import com.goldsanchez.learnverbsenglish.data.PhrasalVerbRepositoryImpl
import com.goldsanchez.learnverbsenglish.data.ProgressRepository
import com.goldsanchez.learnverbsenglish.data.VerbRepository
import com.goldsanchez.learnverbsenglish.data.VerbRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LearningItem {
    data class Irregular(
        val infinitive: String, 
        val past: String, 
        val participle: String, 
        val hInf: String,
        val hPast: String,
        val hPart: String,
        val translation: String, 
        val exPast: String, 
        val exPastTrans: String,
        val hSpanPast: String,
        val exPart: String,
        val exPartTrans: String,
        val hSpanPart: String
    ) : LearningItem()
    
    data class Phrasal(
        val verb: String, 
        val translation: String, 
        val ex1: String, 
        val ex1Trans: String,
        val hSpan1: String
    ) : LearningItem()
}

enum class LearningFilter {
    ALL, IRREGULAR, PHRASAL
}

class FlashcardViewModel(
    private val irregularRepo: VerbRepository = VerbRepositoryImpl(),
    private val phrasalRepo: PhrasalVerbRepository = PhrasalVerbRepositoryImpl(),
    private val progressRepository: ProgressRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _items = MutableStateFlow<List<LearningItem>>(emptyList())
    val items: StateFlow<List<LearningItem>> = _items.asStateFlow()

    private val _selectedFilter = MutableStateFlow(LearningFilter.ALL)
    val selectedFilter: StateFlow<LearningFilter> = _selectedFilter.asStateFlow()

    val learnedVerbs = progressRepository.learnedVerbs

    private var allIrregulars: List<LearningItem.Irregular> = emptyList()
    private var allPhrasals: List<LearningItem.Phrasal> = emptyList()

    init {
        loadData()
        applyFilter(LearningFilter.ALL)
    }

    private fun loadData() {
        allIrregulars = irregularRepo.getVerbs().map {
            LearningItem.Irregular(
                infinitive = it.infinitive.split("/")[0],
                past = it.past.split("/")[0],
                participle = it.participle.split("/")[0],
                hInf = it.infinitive,
                hPast = it.past,
                hPart = it.participle,
                translation = it.translation,
                exPast = it.examplePast,
                exPastTrans = it.examplePastTranslation,
                hSpanPast = it.highlightSpanishPast,
                exPart = it.exampleParticiple,
                exPartTrans = it.exampleParticipleTranslation,
                hSpanPart = it.highlightSpanishParticiple
            )
        }
        allPhrasals = phrasalRepo.getPhrasalVerbs().map {
            LearningItem.Phrasal(
                verb = it.verb, 
                translation = it.translation,
                ex1 = it.examplePresent, 
                ex1Trans = it.examplePresentTranslation,
                hSpan1 = it.highlightSpanishPresent
            )
        }
    }

    fun applyFilter(filter: LearningFilter) {
        _selectedFilter.value = filter
        _items.value = when (filter) {
            LearningFilter.ALL -> (allIrregulars + allPhrasals).shuffled()
            LearningFilter.IRREGULAR -> allIrregulars.shuffled()
            LearningFilter.PHRASAL -> allPhrasals.shuffled()
        }
    }

    fun toggleLearned(verbId: String) {
        val userId = authRepository.currentUser.value?.uid
        viewModelScope.launch {
            progressRepository.toggleVerbProgress(userId, verbId)
        }
    }
}
