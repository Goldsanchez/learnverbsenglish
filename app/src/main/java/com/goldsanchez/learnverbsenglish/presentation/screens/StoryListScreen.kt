package com.goldsanchez.learnverbsenglish.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.domain.model.Story
import com.goldsanchez.learnverbsenglish.presentation.StoryViewModel
import com.goldsanchez.learnverbsenglish.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryListScreen(
    viewModel: StoryViewModel,
    isPremium: Boolean,
    onBack: () -> Unit,
    onStoryClick: (String) -> Unit,
    onPayClick: () -> Unit
) {
    val completedStories by viewModel.completedStories.collectAsState()
    
    // Ordenar historias: las NO completadas primero, las completadas al final
    val sortedStories = viewModel.stories.sortedBy { completedStories.contains(it.id) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Historias Cortas", fontWeight = FontWeight.Bold, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = AccentColor)
            )
        },
        containerColor = Color(0xFFF8F9FA)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(text = "Aprende con el contexto", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = PrimaryColor)
                Text(text = "Lee y escucha historias. Tu progreso se marca al terminar de leer.", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 16.dp))
            }

            items(sortedStories) { story ->
                val isLearned = completedStories.contains(story.id)
                StoryCard(
                    story = story,
                    isLocked = story.isPremium && !isPremium,
                    isLearned = isLearned,
                    onClick = {
                        if (story.isPremium && !isPremium) onPayClick() else onStoryClick(story.id)
                    }
                )
            }
        }
    }
}

@Composable
fun StoryCard(story: Story, isLocked: Boolean, isLearned: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        // Fondo verde si está aprendida
        color = if (isLearned) Color(0xFFE8F5E9) else Color.White,
        shadowElevation = if (isLearned) 0.dp else 2.dp,
        modifier = Modifier.fillMaxWidth(),
        border = if (isLearned) BorderStroke(1.dp, Color(0xFF4CAF50).copy(alpha = 0.3f)) else null
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        when {
                            isLearned -> Color(0xFF4CAF50).copy(alpha = 0.1f)
                            isLocked -> Color.LightGray.copy(alpha = 0.2f)
                            else -> AccentColor.copy(alpha = 0.1f)
                        },
                        RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when {
                        isLearned -> Icons.Default.CheckCircle
                        isLocked -> Icons.Default.Lock
                        else -> Icons.Default.Book
                    },
                    contentDescription = null,
                    tint = when {
                        isLearned -> Color(0xFF4CAF50)
                        isLocked -> Color.Gray
                        else -> AccentColor
                    },
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = story.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isLearned) Color(0xFF2E7D32) else if (isLocked) Color.Gray else PrimaryColor
                )
                
                Surface(
                    color = when(story.level) {
                        "Basic" -> Color(0xFFE8F5E9)
                        "Intermediate" -> Color(0xFFFFF3E0)
                        else -> Color(0xFFFFEBEE)
                    },
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(
                        text = story.level,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = when(story.level) {
                            "Basic" -> Color(0xFF2E7D32)
                            "Intermediate" -> Color(0xFFEF6C00)
                            else -> Color(0xFFC62828)
                        }
                    )
                }
            }

            if (!isLocked && !isLearned) {
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(20.dp))
            }
        }
    }
}
