package com.goldsanchez.learnverbsenglish.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Aprende con el contexto",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Lee historias diseñadas para practicar verbos irregulares y phrasal verbs.",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items(viewModel.stories) { story ->
                StoryCard(
                    story = story,
                    isLocked = story.isPremium && !isPremium,
                    onClick = {
                        if (story.isPremium && !isPremium) {
                            onPayClick()
                        } else {
                            onStoryClick(story.id)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun StoryCard(story: Story, isLocked: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        color = Color.White,
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        if (isLocked) Color.LightGray.copy(alpha = 0.2f) else AccentColor.copy(alpha = 0.1f),
                        RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isLocked) Icons.Default.Lock else Icons.Default.Book,
                    contentDescription = null,
                    tint = if (isLocked) Color.Gray else AccentColor,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = story.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isLocked) Color.Gray else PrimaryColor
                    )
                }
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Surface(
                        color = when(story.level) {
                            "Basic" -> Color(0xFFE8F5E9)
                            "Intermediate" -> Color(0xFFFFF3E0)
                            else -> Color(0xFFFFEBEE)
                        },
                        shape = RoundedCornerShape(4.dp)
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
            }

            if (!isLocked) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
