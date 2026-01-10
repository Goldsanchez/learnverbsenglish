package com.goldsanchez.learnverbsenglish.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.ui.theme.AccentColor
import com.goldsanchez.learnverbsenglish.ui.theme.PrimaryColor
import com.goldsanchez.learnverbsenglish.ui.theme.SpanishTextColor

@Composable
fun VerbBox(text: String, label: String, color: Color, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.9f)
                .clickable { onClick() },
            shape = RoundedCornerShape(24.dp),
            color = color,
            shadowElevation = 4.dp
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.background(
                    Brush.verticalGradient(
                        colors = listOf(Color.White.copy(alpha = 0.3f), Color.Transparent)
                    )
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    // Si el texto tiene un slash, lo dividimos en dos líneas para que quepa mejor
                    val displayText = if (text.contains("/")) {
                        text.replace("/", "/\n")
                    } else {
                        text
                    }
                    
                    Text(
                        text = displayText,
                        fontSize = if (text.length > 12) 14.sp else 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryColor,
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Icon(
                        Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = null,
                        tint = AccentColor.copy(alpha = 0.6f),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
        Text(
            label,
            fontSize = 11.sp,
            color = SpanishTextColor,
            modifier = Modifier.padding(top = 8.dp),
            fontWeight = FontWeight.Bold
        )
    }
}
