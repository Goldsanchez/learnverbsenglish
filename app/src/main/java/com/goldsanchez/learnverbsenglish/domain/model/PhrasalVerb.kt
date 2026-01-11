package com.goldsanchez.learnverbsenglish.domain.model

data class PhrasalVerb(
    val verb: String,
    val translation: String,
    val usageContext: String,
    val examplePresent: String,
    val examplePresentTranslation: String,
    val highlightSpanishPresent: String,
    val examplePast: String,
    val examplePastTranslation: String,
    val highlightSpanishPast: String,
    val exampleCommon: String,
    val exampleCommonTranslation: String,
    val highlightSpanishCommon: String
)
