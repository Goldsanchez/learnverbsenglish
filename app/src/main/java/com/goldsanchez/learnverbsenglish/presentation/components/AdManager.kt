package com.goldsanchez.learnverbsenglish.presentation.components

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

object AdManager {
    private var mInterstitialAd: InterstitialAd? = null
    
    // Inicializamos con el tiempo actual para que la espera de 5 min empiece desde el inicio de la app
    private var lastAdShowTime: Long = System.currentTimeMillis() 
    
    private const val AD_INTERVAL_MS = 5 * 60 * 1000 // 5 minutos

    fun loadInterstitial(context: Context) {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712", // ID de prueba
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                }
            }
        )
    }

    fun showInterstitial(activity: Activity, onAdClosed: () -> Unit) {
        val currentTime = System.currentTimeMillis()
        val timeSinceLastAd = currentTime - lastAdShowTime
        
        // Solo mostramos si el anuncio está cargado Y han pasado 5 minutos
        if (mInterstitialAd != null && timeSinceLastAd >= AD_INTERVAL_MS) {
            mInterstitialAd?.fullScreenContentCallback = object : com.google.android.gms.ads.FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    mInterstitialAd = null
                    lastAdShowTime = System.currentTimeMillis() // Resetear el contador al cerrar
                    loadInterstitial(activity) 
                    onAdClosed()
                }

                override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                    mInterstitialAd = null
                    onAdClosed()
                }
            }
            mInterstitialAd?.show(activity)
        } else {
            // Si intentas salir antes de los 5 min, la app vuelve atrás sin anuncio
            onAdClosed()
        }
    }
}
