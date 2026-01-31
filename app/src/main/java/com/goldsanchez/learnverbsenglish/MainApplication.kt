package com.goldsanchez.learnverbsenglish

import android.app.Application
import com.revenuecat.purchases.Purchases
import com.revenuecat.purchases.PurchasesConfiguration

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Inicialización de RevenueCat
        // Reemplaza "goog_xxxxxxxxxxxxxxxxxxxxxxxxxx" con tu Public API Key de RevenueCat
        Purchases.configure(
            PurchasesConfiguration.Builder(this, "test_AqQoEpjDMWEThcHyIiUhGbDIXZU").build()
        )
    }
}
