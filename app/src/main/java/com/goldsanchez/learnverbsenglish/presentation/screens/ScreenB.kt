package com.goldsanchez.learnverbsenglish.presentation.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.domain.model.Verb
import com.goldsanchez.learnverbsenglish.presentation.VerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.components.VerbBox
import com.goldsanchez.learnverbsenglish.presentation.utils.getAnnotatedString
import com.goldsanchez.learnverbsenglish.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(verbIndex: Int, viewModel: VerbViewModel, tts: TextToSpeech?, onBack: () -> Unit, onNavigate: (Int) -> Unit) {
    val verb = viewModel.getVerbByIndex(verbIndex) ?: return
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(verb.translation, fontWeight = FontWeight.SemiBold, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AccentColor
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp, start = 24.dp, end = 24.dp, top = 12.dp)
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    onClick = { if (verbIndex > 0) onNavigate(verbIndex - 1) },
                    enabled = verbIndex > 0,
                    shape = RoundedCornerShape(16.dp),
                    color = if (verbIndex > 0) ColorList[0] else Color.LightGray.copy(alpha = 0.2f),
                    modifier = Modifier.weight(1f),
                    shadowElevation = if (verbIndex > 0) 4.dp else 0.dp
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 14.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft, 
                            contentDescription = null, 
                            tint = if (verbIndex > 0) PrimaryColor else Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            "Anterior", 
                            fontWeight = FontWeight.Bold, 
                            color = if (verbIndex > 0) PrimaryColor else Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                }

                Surface(
                    onClick = { if (verbIndex < viewModel.getTotalVerbs() - 1) onNavigate(verbIndex + 1) },
                    enabled = verbIndex < viewModel.getTotalVerbs() - 1,
                    shape = RoundedCornerShape(16.dp),
                    color = if (verbIndex < viewModel.getTotalVerbs() - 1) ColorList[1] else Color.LightGray.copy(alpha = 0.2f),
                    modifier = Modifier.weight(1f),
                    shadowElevation = if (verbIndex < viewModel.getTotalVerbs() - 1) 4.dp else 0.dp
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 14.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Siguiente", 
                            fontWeight = FontWeight.Bold, 
                            color = if (verbIndex < viewModel.getTotalVerbs() - 1) PrimaryColor else Color.Gray,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowRight, 
                            contentDescription = null, 
                            tint = if (verbIndex < viewModel.getTotalVerbs() - 1) PrimaryColor else Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        },
        containerColor = BackgroundColor
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    .padding(bottom = 20.dp)
            ) {
                Column(modifier = Modifier.padding(start = 4.dp)) {
                    Text(
                        "EXAMPLES",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = AccentColor,
                        letterSpacing = 1.5.sp
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .width(32.dp)
                            .height(3.dp)
                            .background(AccentColor, RoundedCornerShape(2.dp))
                    )
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
