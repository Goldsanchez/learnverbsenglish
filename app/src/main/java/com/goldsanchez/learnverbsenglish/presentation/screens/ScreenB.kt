package com.goldsanchez.learnverbsenglish.presentation.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.rounded.RecordVoiceOver
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.domain.model.Verb
import com.goldsanchez.learnverbsenglish.presentation.IrregularVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.components.AdBanner
import com.goldsanchez.learnverbsenglish.presentation.components.VerbBox
import com.goldsanchez.learnverbsenglish.presentation.utils.getAnnotatedString
import com.goldsanchez.learnverbsenglish.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(verbIndex: Int, viewModel: IrregularVerbViewModel, tts: TextToSpeech?, onBack: () -> Unit) {
    val pagerState = rememberPagerState(initialPage = verbIndex, pageCount = { viewModel.verbs.size })
    val isAdsRemoved by viewModel.isAdsRemoved.collectAsState()
    val learnedVerbs by viewModel.learnedVerbs.collectAsState()

    Scaffold(
        topBar = {
            val currentVerb = viewModel.verbs[pagerState.currentPage]
            CenterAlignedTopAppBar(
                title = { Text(currentVerb.translation, fontWeight = FontWeight.SemiBold, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    FilledIconButton(
                        onClick = {
                            tts?.let {
                                it.speak(currentVerb.infinitive, TextToSpeech.QUEUE_FLUSH, null, "infinitive")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.past, TextToSpeech.QUEUE_ADD, null, "past")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.participle, TextToSpeech.QUEUE_ADD, null, "participle")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.exampleInfinitive, TextToSpeech.QUEUE_ADD, null, "exampleInfinitive")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.examplePast, TextToSpeech.QUEUE_ADD, null, "examplePast")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.exampleParticiple, TextToSpeech.QUEUE_ADD, null, "exampleParticiple")
                            }
                        },
                        modifier = Modifier.padding(end = 8.dp).size(40.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = Color.White.copy(alpha = 0.2f),
                            contentColor = Color.White
                        )
                    ) {
                        Icon(Icons.Rounded.RecordVoiceOver, contentDescription = "Reproducir toda la ficha", modifier = Modifier.size(24.dp))
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = AccentColor)
            )
        },
        bottomBar = {
            if (!isAdsRemoved) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor)
                        .navigationBarsPadding()
                ) {
                    AdBanner(modifier = Modifier.padding(vertical = 12.dp))
                }
            }
        },
        containerColor = BackgroundColor
    ) { padding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize().padding(padding)
        ) { page ->
            val verb = viewModel.verbs[page]
            val scrollState = rememberScrollState()
            val isLearned = learnedVerbs.contains(verb.infinitive)
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (!isAdsRemoved) {
                    AdBanner(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp))
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    VerbBox(verb.infinitive, "Infinitive", BoxBlue, Modifier.weight(1f)) { tts?.speak(verb.infinitive, TextToSpeech.QUEUE_FLUSH, null, null) }
                    VerbBox(verb.past, "Past", BoxGreen, Modifier.weight(1f)) { tts?.speak(verb.past, TextToSpeech.QUEUE_FLUSH, null, null) }
                    VerbBox(verb.participle, "Participle", BoxOrange, Modifier.weight(1f)) { tts?.speak(verb.participle, TextToSpeech.QUEUE_FLUSH, null, null) }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                ) {
                    // Linea EXAMPLES con botón Aprendido a la derecha
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("EXAMPLES", fontSize = 13.sp, fontWeight = FontWeight.Black, color = AccentColor, letterSpacing = 1.5.sp)
                            Box(modifier = Modifier.padding(top = 4.dp).width(32.dp).height(3.dp).background(AccentColor, RoundedCornerShape(2.dp)))
                        }
                        
                        // Botón de Aprendido
                        Surface(
                            onClick = { viewModel.toggleLearned(verb.infinitive) },
                            color = if (isLearned) Color(0xFF4CAF50) else Color.Transparent,
                            shape = RoundedCornerShape(12.dp),
                            border = if (!isLearned) BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)) else null
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Aprendido", 
                                    fontSize = 12.sp, 
                                    fontWeight = FontWeight.Bold, 
                                    color = if (isLearned) Color.White else Color.Gray
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(
                                    imageVector = if (isLearned) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                                    contentDescription = null,
                                    tint = if (isLearned) Color.White else Color.Gray.copy(alpha = 0.4f),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))

                    ExampleItemImproved("Present Form", verb.exampleInfinitive, verb.exampleInfinitiveTranslation, verb.infinitive, verb.highlightSpanishInfinitive, tts)
                    Spacer(modifier = Modifier.height(20.dp))
                    ExampleItemImproved("Past Simple Form", verb.examplePast, verb.examplePastTranslation, verb.past, verb.highlightSpanishPast, tts)
                    Spacer(modifier = Modifier.height(20.dp))
                    ExampleItemImproved("Participle Form", verb.exampleParticiple, verb.exampleParticipleTranslation, verb.participle, verb.highlightSpanishParticiple, tts)
                }
            }
        }
    }
}

@Composable
fun ExampleItemImproved(label: String, english: String, spanish: String, englishVerb: String, spanishVerb: String, tts: TextToSpeech?) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray.copy(alpha = 0.8f),
            modifier = Modifier.padding(start = 4.dp, bottom = 6.dp)
        )
        
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { tts?.speak(english, TextToSpeech.QUEUE_FLUSH, null, null) },
            color = Color.White,
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 1.dp
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(AccentColor.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = "Listen",
                        tint = AccentColor,
                        modifier = Modifier.size(18.dp)
                    )
                }
                
                Text(
                    text = getAnnotatedString(english, englishVerb, EnglishTextColor, AccentColor),
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        
        Text(
            text = getAnnotatedString(spanish, spanishVerb, SpanishTextColor, Color.Black),
            fontSize = 14.sp,
            color = SpanishTextColor,
            modifier = Modifier.padding(start = 12.dp, top = 6.dp, end = 12.dp),
            lineHeight = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
