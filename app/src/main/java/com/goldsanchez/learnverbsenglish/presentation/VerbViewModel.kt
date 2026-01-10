package com.goldsanchez.learnverbsenglish.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.goldsanchez.learnverbsenglish.data.VerbRepository
import com.goldsanchez.learnverbsenglish.data.VerbRepositoryImpl
import com.goldsanchez.learnverbsenglish.domain.model.Verb

class VerbViewModel(private val repository: VerbRepository = VerbRepositoryImpl()) : ViewModel() {
    var searchQuery by mutableStateOf("")
        private set

    val verbs: List<Verb> = repository.getVerbs()

    val filteredVerbs: List<Verb>
        get() = verbs.filter {
            it.infinitive.contains(searchQuery, ignoreCase = true) ||
            it.translation.contains(searchQuery, ignoreCase = true)
        }

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }

    fun getVerbByIndex(index: Int): Verb? {
        return if (index in verbs.indices) verbs[index] else null
    }

    fun getTotalVerbs(): Int = verbs.size
}
