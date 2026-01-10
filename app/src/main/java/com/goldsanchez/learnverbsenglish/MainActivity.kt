package com.goldsanchez.learnverbsenglish

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.goldsanchez.learnverbsenglish.data.BillingRepository
import com.goldsanchez.learnverbsenglish.presentation.VerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.navigation.NavGraph
import com.goldsanchez.learnverbsenglish.ui.theme.LearnverbsenglishTheme
import com.google.android.gms.ads.MobileAds
import java.util.*

class MainActivity : ComponentActivity() {
    private var tts: TextToSpeech? = null
    private lateinit var billingRepository: BillingRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize Mobile Ads SDK
        MobileAds.initialize(this) {}

        billingRepository = BillingRepository(applicationContext)

        tts = TextToSpeech(this) { status ->
            if (status != TextToSpeech.ERROR) {
                tts?.language = Locale.US
            }
        }

        enableEdgeToEdge()
        setContent {
            LearnverbsenglishTheme {
                val viewModel: VerbViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return VerbViewModel(billingRepository = billingRepository) as T
                        }
                    }
                )
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
