package com.goldsanchez.learnverbsenglish.presentation.screens

import android.speech.tts.TextToSpeech
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
import androidx.compose.material.icons.rounded.RecordVoiceOver
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.presentation.PhrasalVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.components.AdBanner
import com.goldsanchez.learnverbsenglish.presentation.utils.getAnnotatedString
import com.goldsanchez.learnverbsenglish.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhrasalScreenB(verbIndex: Int, viewModel: PhrasalVerbViewModel, tts: TextToSpeech?, onBack: () -> Unit) {
    val pagerState = rememberPagerState(initialPage = verbIndex, pageCount = { viewModel.phrasalVerbs.size })
    val isAdsRemoved by viewModel.isAdsRemoved.collectAsState()

    Scaffold(
        topBar = {
            val currentVerb = viewModel.phrasalVerbs[pagerState.currentPage]
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
                                it.speak(currentVerb.verb, TextToSpeech.QUEUE_FLUSH, null, "verb")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.examplePresent, TextToSpeech.QUEUE_ADD, null, "examplePresent")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.examplePast, TextToSpeech.QUEUE_ADD, null, "examplePast")
                                it.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null)
                                it.speak(currentVerb.exampleCommon, TextToSpeech.QUEUE_ADD, null, "exampleCommon")
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
            val verb = viewModel.phrasalVerbs[page]
            val scrollState = rememberScrollState()
            
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

                Text(
                    text = verb.verb,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = PrimaryColor
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Context Card
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = BoxBlue,
                    shape = RoundedCornerShape(24.dp),
                    shadowElevation = 2.dp
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = verb.usageContext,
                            fontSize = 14.sp,
                            color = SpanishTextColor,
                            lineHeight = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Examples Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                ) {
                    Column(modifier = Modifier.padding(start = 4.dp)) {
                        Text("EXAMPLES", fontSize = 13.sp, fontWeight = FontWeight.Black, color = AccentColor, letterSpacing = 1.5.sp)
                        Box(modifier = Modifier.padding(top = 4.dp).width(32.dp).height(3.dp).background(AccentColor, RoundedCornerShape(2.dp)))
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))

                    ExampleItemPhrasal("1. Presente", verb.examplePresent, verb.examplePresentTranslation, verb.verb, verb.highlightSpanishPresent, tts)
                    Spacer(modifier = Modifier.height(20.dp))
                    ExampleItemPhrasal("2. Pasado Simple", verb.examplePast, verb.examplePastTranslation, verb.verb, verb.highlightSpanishPast, tts)
                    Spacer(modifier = Modifier.height(20.dp))
                    ExampleItemPhrasal("3. Participio", verb.exampleCommon, verb.exampleCommonTranslation, verb.verb, verb.highlightSpanishCommon, tts)
                }
            }
        }
    }
}

@Composable
fun ExampleItemPhrasal(label: String, english: String, spanish: String, englishVerb: String, spanishVerb: String, tts: TextToSpeech?) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Gray.copy(alpha = 0.8f), modifier = Modifier.padding(start = 4.dp, bottom = 6.dp))
        
        Surface(
            modifier = Modifier.fillMaxWidth().clickable { tts?.speak(english, TextToSpeech.QUEUE_FLUSH, null, null) },
            color = Color.White,
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 1.dp
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(modifier = Modifier.size(32.dp).clip(CircleShape).background(AccentColor.copy(alpha = 0.1f)), contentAlignment = Alignment.Center) {
                    Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = "Listen", tint = AccentColor, modifier = Modifier.size(18.dp))
                }
                Text(text = getAnnotatedString(english, englishVerb, EnglishTextColor, AccentColor), fontSize = 15.sp, lineHeight = 20.sp, modifier = Modifier.weight(1f))
            }
        }
        Text(text = getAnnotatedString(spanish, spanishVerb, SpanishTextColor, Color.Black), fontSize = 14.sp, color = SpanishTextColor, modifier = Modifier.padding(start = 12.dp, top = 6.dp, end = 12.dp), lineHeight = 18.sp, fontWeight = FontWeight.Medium)
    }
}
