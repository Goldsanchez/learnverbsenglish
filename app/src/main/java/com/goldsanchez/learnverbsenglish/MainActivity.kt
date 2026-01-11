package com.goldsanchez.learnverbsenglish

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.goldsanchez.learnverbsenglish.presentation.navigation.NavGraph
import com.goldsanchez.learnverbsenglish.ui.theme.LearnverbsenglishTheme
import com.google.android.gms.ads.MobileAds
import java.util.*

class MainActivity : ComponentActivity() {
    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        
        MobileAds.initialize(this) {}

        tts = TextToSpeech(this) { status ->
            if (status != TextToSpeech.ERROR) {
                tts?.language = Locale.US
            }
        }

        enableEdgeToEdge()
        setContent {
            LearnverbsenglishTheme {
                NavGraph(tts = tts)
            }
        }
    }

    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        super.onDestroy()
    }
}
