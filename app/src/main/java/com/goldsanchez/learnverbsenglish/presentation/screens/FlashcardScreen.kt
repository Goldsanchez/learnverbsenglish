package com.goldsanchez.learnverbsenglish.presentation.screens

import android.app.Activity
import android.speech.tts.TextToSpeech
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.goldsanchez.learnverbsenglish.presentation.FlashcardViewModel
import com.goldsanchez.learnverbsenglish.presentation.LearningFilter
import com.goldsanchez.learnverbsenglish.presentation.LearningItem
import com.goldsanchez.learnverbsenglish.presentation.components.AdManager
import com.goldsanchez.learnverbsenglish.presentation.utils.getAnnotatedString
import com.goldsanchez.learnverbsenglish.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashcardScreen(
    viewModel: FlashcardViewModel,
    isAdsRemoved: Boolean,
    tts: TextToSpeech?,
    onBack: () -> Unit
) {
    val items by viewModel.items.collectAsState()
    val learnedVerbs by viewModel.learnedVerbs.collectAsState()
    val selectedFilter by viewModel.selectedFilter.collectAsState()
    val pagerState = rememberPagerState(pageCount = { items.size })
    val context = LocalContext.current
    
    var isMuted by remember { mutableStateOf(false) }
    var swipeCounter by remember { mutableIntStateOf(0) }

    LaunchedEffect(pagerState.currentPage, items, isMuted) {
        if (items.isNotEmpty() && !isMuted) {
            delay(800) 
            val item = items[pagerState.currentPage]
            tts?.let {
                when (item) {
                    is LearningItem.Irregular -> {
                        it.speak("${item.infinitive}, ${item.past}, ${item.participle}", TextToSpeech.QUEUE_FLUSH, null, "words")
                        it.playSilentUtterance(600, TextToSpeech.QUEUE_ADD, null)
                        it.speak("Example in past: ${item.exPast}", TextToSpeech.QUEUE_ADD, null, "ex1")
                        it.playSilentUtterance(600, TextToSpeech.QUEUE_ADD, null)
                        it.speak("Example in participle: ${item.exPart}", TextToSpeech.QUEUE_ADD, null, "ex2")
                    }
                    is LearningItem.Phrasal -> {
                        it.speak(item.verb, TextToSpeech.QUEUE_FLUSH, null, "verb")
                        it.playSilentUtterance(400, TextToSpeech.QUEUE_ADD, null)
                        it.speak("means ${item.translation}", TextToSpeech.QUEUE_ADD, null, "trans")
                        it.playSilentUtterance(600, TextToSpeech.QUEUE_ADD, null)
                        it.speak(item.ex1, TextToSpeech.QUEUE_ADD, null, "ex1")
                    }
                }
            }
        } else if (isMuted) {
            tts?.stop()
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        if (items.isNotEmpty()) {
            swipeCounter++
            if (swipeCounter >= 10 && !isAdsRemoved) {
                AdManager.showInterstitial(context as Activity) { swipeCounter = 0 }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF0F172A))) {
        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            key = { page -> if (page < items.size) items[page].hashCode() else page }
        ) { page ->
            val item = items[page]
            val isLearned = when (item) {
                is LearningItem.Irregular -> learnedVerbs.contains(item.infinitive)
                is LearningItem.Phrasal -> learnedVerbs.contains(item.verb)
            }
            
            val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

            FlashcardTikTokItem(
                item = item,
                isLearned = isLearned,
                onToggleLearned = { id -> viewModel.toggleLearned(id) },
                tts = tts,
                isMuted = isMuted,
                onToggleMute = { isMuted = !isMuted },
                modifier = Modifier.graphicsLayer {
                    val scale = lerp(0.85f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                    scaleX = scale
                    scaleY = scale
                    alpha = lerp(0.4f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                }
            )
        }

        // Overlay Navigation
        Column(modifier = Modifier.fillMaxWidth().statusBarsPadding()) {
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, null, tint = Color.White, modifier = Modifier.size(32.dp)) }
                Spacer(modifier = Modifier.weight(1f))
                ScrollableTabRow(
                    selectedTabIndex = selectedFilter.ordinal,
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                    edgePadding = 16.dp,
                    divider = {},
                    indicator = { tabPositions -> TabRowDefaults.SecondaryIndicator(Modifier.tabIndicatorOffset(tabPositions[selectedFilter.ordinal]), color = Color(0xFF38BDF8), height = 2.dp) },
                    modifier = Modifier.widthIn(max = 260.dp)
                ) {
                    LearningFilter.entries.forEach { filter ->
                        Tab(
                            selected = selectedFilter == filter,
                            onClick = { viewModel.applyFilter(filter) },
                            text = { Text(text = filter.name.lowercase().replaceFirstChar { it.uppercase() }, style = TextStyle(fontSize = 14.sp, fontWeight = if (selectedFilter == filter) FontWeight.Bold else FontWeight.Normal, color = if (selectedFilter == filter) Color.White else Color.White.copy(alpha = 0.5f))) }
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.size(48.dp))
            }
        }
    }
}

@Composable
fun FlashcardTikTokItem(
    item: LearningItem,
    isLearned: Boolean,
    onToggleLearned: (String) -> Unit,
    tts: TextToSpeech?,
    isMuted: Boolean,
    onToggleMute: () -> Unit,
    modifier: Modifier = Modifier
) {
    val irregularAccent = Color(0xFF38BDF8)
    val phrasalAccent = Color(0xFFF472B6)
    val currentAccent = if (item is LearningItem.Irregular) irregularAccent else phrasalAccent
    
    var showTranslation by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { showTranslation = !showTranslation }
    ) {
        Box(modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color.Black, currentAccent.copy(alpha = 0.15f), Color.Black))))

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when(item) {
                is LearningItem.Irregular -> {
                    val translations = item.translation.split("/")
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        translations.forEach { tr ->
                            Text(text = tr.trim(), style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Black, color = Color.White, fontFamily = FontFamily.Serif))
                        }
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    val infinitiveFontSize = if (item.infinitive.length > 10) 48.sp else 64.sp
                    Text(text = item.infinitive, style = TextStyle(fontSize = infinitiveFontSize, fontWeight = FontWeight.Black, color = Color.White, letterSpacing = (-2).sp), textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(40.dp))
                    VerbFormCardTikTokVibrant(label = "PAST SIMPLE", value = item.past, color = phrasalAccent)
                    Spacer(modifier = Modifier.height(12.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = getAnnotatedString(item.exPast, item.past, Color.White.copy(alpha = 0.6f), phrasalAccent), style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center), modifier = Modifier.padding(horizontal = 16.dp))
                        AnimatedVisibility(visible = showTranslation) {
                            Text(text = getAnnotatedString(item.exPastTrans, item.hSpanPast, phrasalAccent.copy(alpha = 0.8f), Color.White), style = TextStyle(fontSize = 13.sp, textAlign = TextAlign.Center), modifier = Modifier.padding(top = 4.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    VerbFormCardTikTokVibrant(label = "PAST PARTICIPLE", value = item.participle, color = irregularAccent)
                    Spacer(modifier = Modifier.height(12.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = getAnnotatedString(item.exPart, item.participle, Color.White.copy(alpha = 0.6f), irregularAccent), style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center), modifier = Modifier.padding(horizontal = 16.dp))
                        AnimatedVisibility(visible = showTranslation) {
                            Text(text = getAnnotatedString(item.exPartTrans, item.hSpanPart, irregularAccent.copy(alpha = 0.8f), Color.White), style = TextStyle(fontSize = 13.sp, textAlign = TextAlign.Center), modifier = Modifier.padding(top = 4.dp))
                        }
                    }
                }
                is LearningItem.Phrasal -> {
                    val translations = item.translation.split("/")
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        translations.forEach { tr ->
                            Text(text = tr.trim(), style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, color = phrasalAccent, fontFamily = FontFamily.Serif))
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    val verbFontSize = if (item.verb.length > 12) 42.sp else 56.sp
                    Text(text = item.verb, style = TextStyle(fontSize = verbFontSize, fontWeight = FontWeight.Black, color = Color.White, letterSpacing = (-1).sp), textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(56.dp))
                    ExampleBoxSimpleTikTok(getAnnotatedString(item.ex1, item.verb, Color.White, phrasalAccent), getAnnotatedString(item.ex1Trans, item.hSpan1, phrasalAccent.copy(alpha = 0.8f), Color.White), showTranslation)
                }
            }
        }

        // Bottom Actions
        Row(
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().padding(bottom = 48.dp, start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val id = if (item is LearningItem.Irregular) item.infinitive else (item as LearningItem.Phrasal).verb
            TikTokActionButtonBottomFlash(icon = if (isMuted) Icons.Default.VolumeOff else Icons.Default.VolumeUp, label = if (isMuted) "Silencio" else "Escuchar", color = if (isMuted) Color.Gray else Color.White) { onToggleMute() }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.KeyboardArrowUp, null, tint = Color.White.copy(alpha = 0.3f), modifier = Modifier.size(24.dp))
                Text("SWIPE UP", style = TextStyle(fontSize = 10.sp, color = Color.White.copy(alpha = 0.3f), letterSpacing = 2.sp, fontWeight = FontWeight.Bold))
            }
            TikTokActionButtonBottomFlash(icon = if (isLearned) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle, label = if (isLearned) "Learned" else "Mark", color = if (isLearned) Color(0xFF10B981) else Color.White) { onToggleLearned(id) }
        }
    }
}

@Composable
fun ExampleBoxSimpleTikTok(english: androidx.compose.ui.text.AnnotatedString, spanish: androidx.compose.ui.text.AnnotatedString, showTranslation: Boolean) {
    Surface(color = Color.White.copy(alpha = 0.04f), shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f)), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = english, style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center, color = Color.White), lineHeight = 22.sp)
            AnimatedVisibility(visible = showTranslation) {
                Text(text = spanish, modifier = Modifier.padding(top = 8.dp), textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun TikTokActionButtonBottomFlash(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, color: Color = Color.White, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable(onClick = onClick)) {
        Surface(color = color.copy(alpha = 0.1f), shape = CircleShape, modifier = Modifier.size(54.dp), border = BorderStroke(1.dp, color.copy(alpha = 0.2f))) {
            Box(contentAlignment = Alignment.Center) { Icon(icon, null, tint = color, modifier = Modifier.size(28.dp)) }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = label, style = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Bold, color = color))
    }
}

@Composable
fun VerbFormCardTikTokVibrant(label: String, value: String, color: Color) {
    Surface(modifier = Modifier.fillMaxWidth(0.8f), color = Color.White.copy(alpha = 0.06f), shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, Color.White.copy(alpha = 0.1f))) {
        Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = label, style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Black, color = color, letterSpacing = 1.5.sp))
            Text(text = value, style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White))
        }
    }
}
