package com.goldsanchez.learnverbsenglish.domain.model

data class Verb(
    val infinitive: String,
    val past: String,
    val participle: String,
    val translation: String,
    val exampleInfinitive: String,
    val exampleInfinitiveTranslation: String,
    val highlightSpanishInfinitive: String,
    val examplePast: String,
    val examplePastTranslation: String,
    val highlightSpanishPast: String,
    val exampleParticiple: String,
    val exampleParticipleTranslation: String,
    val highlightSpanishParticiple: String
)
