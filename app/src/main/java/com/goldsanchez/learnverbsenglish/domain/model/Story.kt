package com.goldsanchez.learnverbsenglish.domain.model

data class Story(
    val id: String,
    val title: String,
    val content: String,
    val spanishContent: String,
    val level: String,
    val isPremium: Boolean,
    val keyWords: List<StoryWord>
)

data class StoryWord(
    val word: String,          // Palabra exacta en inglés
    val spanishWord: String,   // Palabra exacta en español (para resaltar)
    val translation: String,   // Traducción base (para el futuro)
    val baseForm: String,
    val type: String
)
