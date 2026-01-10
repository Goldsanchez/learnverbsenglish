package com.goldsanchez.learnverbsenglish.presentation.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

fun getAnnotatedString(text: String, highlight: String, normalColor: Color, highlightColor: Color): AnnotatedString {
    val highlightParts = highlight.split("/")
    
    return buildAnnotatedString {
        val foundParts = mutableListOf<Pair<Int, Int>>()
        highlightParts.forEach { part ->
            var idx = text.indexOf(part, 0, ignoreCase = true)
            while (idx != -1) {
                val isStartBound = idx == 0 || !text[idx - 1].isLetter()
                val isEndBound = idx + part.length == text.length || !text[idx + part.length].isLetter()
                
                if (isStartBound && isEndBound) {
                    foundParts.add(idx to idx + part.length)
                }
                idx = text.indexOf(part, idx + part.length, ignoreCase = true)
            }
        }
        
        foundParts.sortBy { it.first }
        
        var cursor = 0
        foundParts.forEach { (start, end) ->
            if (start >= cursor) {
                withStyle(style = SpanStyle(color = normalColor)) {
                    append(text.substring(cursor, start))
                }
                withStyle(style = SpanStyle(color = highlightColor, fontWeight = FontWeight.ExtraBold)) {
                    append(text.substring(start, end))
                }
                cursor = end
            }
        }
        
        if (cursor < text.length) {
            withStyle(style = SpanStyle(color = normalColor)) {
                append(text.substring(cursor))
            }
        }
    }
}
