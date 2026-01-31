package com.goldsanchez.learnverbsenglish.presentation.screens

import android.app.Activity
import android.speech.tts.TextToSpeech
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Headset
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.presentation.StoryViewModel
import com.goldsanchez.learnverbsenglish.presentation.components.AdBanner
import com.goldsanchez.learnverbsenglish.presentation.components.AdManager
import com.goldsanchez.learnverbsenglish.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailScreen(
    storyId: String,
    viewModel: StoryViewModel,
    isAdsRemoved: Boolean,
    tts: TextToSpeech?,
    onBack: () -> Unit
) {
    val story = viewModel.getStoryById(storyId) ?: return
    var isPlaying by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val completedStories by viewModel.completedStories.collectAsState()
    val isLearned = completedStories.contains(storyId)
    
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        onDispose {
            tts?.stop()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        text = story.title, 
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (!isAdsRemoved) {
                                AdManager.showInterstitial(context as Activity) { onBack() }
                            } else {
                                onBack()
                            }
                        }
                    ) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    val playIconColor by animateColorAsState(if (isPlaying) Color(0xFFFFD700) else Color.White, label = "")
                    IconButton(
                        onClick = {
                            if (isPlaying) {
                                tts?.stop()
                                isPlaying = false
                            } else {
                                tts?.speak(story.content, TextToSpeech.QUEUE_FLUSH, null, "story_audio")
                                isPlaying = true
                            }
                        }
                    ) {
                        Icon(imageVector = if (isPlaying) Icons.Default.Stop else Icons.Default.Headset, contentDescription = "Audio", tint = playIconColor)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = AccentColor)
            )
        },
        containerColor = Color(0xFFF5F5F5)
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            Surface(color = Color.White, shadowElevation = 2.dp) {
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    containerColor = Color.White,
                    contentColor = AccentColor,
                    divider = {},
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]), color = AccentColor, height = 3.dp)
                    }
                ) {
                    Tab(selected = pagerState.currentPage == 0, onClick = { coroutineScope.launch { pagerState.animateScrollToPage(0) } }, text = { Text("English", style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) })
                    Tab(selected = pagerState.currentPage == 1, onClick = { coroutineScope.launch { pagerState.animateScrollToPage(1) } }, text = { Text("Traducción", style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) })
                }
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Top
            ) { page ->
                val scrollState = rememberScrollState()
                val scrollProgress = if (scrollState.maxValue > 0) {
                    scrollState.value.toFloat() / scrollState.maxValue.toFloat()
                } else 0f

                Box(modifier = Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        color = Color(0xFFFDFCFB),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                        shadowElevation = 4.dp
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Column(modifier = Modifier.padding(horizontal = 24.dp).padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                if (!isAdsRemoved) AdBanner(modifier = Modifier.padding(bottom = 12.dp))
                                StylishLine()
                            }
                            
                            Box(modifier = Modifier.weight(1f).verticalScroll(scrollState).padding(horizontal = 24.dp, vertical = 24.dp)) {
                                val fullText = if (page == 0) story.content else story.spanishContent
                                if (fullText.isNotEmpty()) {
                                    val annotatedContent = buildAnnotatedString {
                                        append(fullText)
                                        story.keyWords.forEach { keyword ->
                                            val target = if (page == 0) keyword.word else keyword.spanishWord
                                            var index = fullText.indexOf(target, 0, ignoreCase = true)
                                            while (index != -1) {
                                                addStyle(style = SpanStyle(color = AccentColor, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline), start = index, end = index + target.length)
                                                index = fullText.indexOf(target, index + 1, ignoreCase = true)
                                            }
                                        }
                                    }
                                    Text(text = annotatedContent, style = TextStyle(fontSize = 20.sp, lineHeight = 36.sp, fontFamily = FontFamily.Serif, color = if (page == 0) Color(0xFF1E293B) else Color(0xFF475569)), modifier = Modifier.fillMaxWidth())
                                }
                            }
                            
                            Column(
                                modifier = Modifier.padding(horizontal = 24.dp).padding(bottom = 16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                // BOTÓN DE APRENDIDO (MANUAL)
                                Surface(
                                    onClick = { viewModel.toggleStoryProgress(storyId) }, // CORRECCIÓN: Nombre de función sincronizado
                                    color = if (isLearned) Color(0xFF4CAF50) else Color.Transparent,
                                    shape = RoundedCornerShape(12.dp),
                                    border = if (!isLearned) BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)) else null,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Leída", 
                                            fontSize = 14.sp, 
                                            fontWeight = FontWeight.Bold, 
                                            color = if (isLearned) Color.White else Color.Gray
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Icon(
                                            imageVector = if (isLearned) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                                            contentDescription = null,
                                            tint = if (isLearned) Color.White else Color.Gray.copy(alpha = 0.4f),
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }

                                StylishLine()
                                if (!isAdsRemoved) { Spacer(modifier = Modifier.height(12.dp)); AdBanner() }
                            }
                        }
                    }
                    LinearProgressIndicator(progress = { scrollProgress }, modifier = Modifier.fillMaxWidth().height(3.dp).align(Alignment.TopCenter), color = AccentColor, trackColor = Color.Transparent)
                }
            }
        }
    }
}

@Composable
fun StylishLine(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(0.4f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Box(modifier = Modifier.weight(1f).height(1.dp).background(brush = Brush.horizontalGradient(colors = listOf(Color.Transparent, AccentColor.copy(alpha = 0.3f)))))
        Box(modifier = Modifier.padding(horizontal = 8.dp).size(4.dp).background(AccentColor.copy(alpha = 0.5f), CircleShape))
        Box(modifier = Modifier.weight(1f).height(1.dp).background(brush = Brush.horizontalGradient(colors = listOf(AccentColor.copy(alpha = 0.3f), Color.Transparent))))
    }
}
