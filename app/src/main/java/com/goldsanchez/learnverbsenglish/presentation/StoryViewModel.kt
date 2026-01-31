package com.goldsanchez.learnverbsenglish.presentation

import androidx.lifecycle.ViewModel
import com.goldsanchez.learnverbsenglish.data.StoryRepository
import com.goldsanchez.learnverbsenglish.data.StoryRepositoryImpl
import com.goldsanchez.learnverbsenglish.domain.model.Story

class StoryViewModel(
    private val repository: StoryRepository = StoryRepositoryImpl()
) : ViewModel() {

    val stories: List<Story> = repository.getStories()

    fun getStoryById(id: String): Story? {
        return repository.getStoryById(id)
    }
}
