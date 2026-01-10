package com.goldsanchez.learnverbsenglish

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.goldsanchez.learnverbsenglish.presentation.VerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.navigation.NavGraph
import com.goldsanchez.learnverbsenglish.ui.theme.LearnverbsenglishTheme
import java.util.*

class MainActivity : ComponentActivity() {
    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        tts = TextToSpeech(this) { status ->
            if (status != TextToSpeech.ERROR) {
                tts?.language = Locale.US
            }
        }

        enableEdgeToEdge()
        setContent {
            LearnverbsenglishTheme {
                val viewModel: VerbViewModel = viewModel()
                NavGraph(viewModel = viewModel, tts = tts)
            }
        }
    }

    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        super.onDestroy()
    }
}
