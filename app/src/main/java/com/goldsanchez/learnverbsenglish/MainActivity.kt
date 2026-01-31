package com.goldsanchez.learnverbsenglish

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.goldsanchez.learnverbsenglish.data.AuthRepository
import com.goldsanchez.learnverbsenglish.data.ProgressRepository
import com.goldsanchez.learnverbsenglish.data.RevenueRepository
import com.goldsanchez.learnverbsenglish.presentation.components.AdManager
import com.goldsanchez.learnverbsenglish.presentation.navigation.NavGraph
import com.goldsanchez.learnverbsenglish.ui.theme.LearnverbsenglishTheme
import com.google.android.gms.ads.MobileAds
import java.util.*

class MainActivity : ComponentActivity() {
    private var tts: TextToSpeech? = null
    private lateinit var revenueRepository: RevenueRepository
    private lateinit var authRepository: AuthRepository
    private lateinit var progressRepository: ProgressRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        
        MobileAds.initialize(this) {
            AdManager.loadInterstitial(this)
        }
        
        // Inicializamos repositorios (Pasando el contexto al ProgressRepository)
        revenueRepository = RevenueRepository()
        progressRepository = ProgressRepository(applicationContext)
        authRepository = AuthRepository(revenueRepository, progressRepository)

        tts = TextToSpeech(this) { status ->
            if (status != TextToSpeech.ERROR) {
                tts?.language = Locale.US
            }
        }

        enableEdgeToEdge()
        setContent {
            LearnverbsenglishTheme {
                NavGraph(
                    tts = tts, 
                    revenueRepository = revenueRepository,
                    authRepository = authRepository,
                    progressRepository = progressRepository
                )
            }
        }
    }

    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        super.onDestroy()
    }
}
