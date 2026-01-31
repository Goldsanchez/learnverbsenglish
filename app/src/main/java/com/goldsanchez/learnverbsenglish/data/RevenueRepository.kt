package com.goldsanchez.learnverbsenglish.data

import android.app.Activity
import com.revenuecat.purchases.CustomerInfo
import com.revenuecat.purchases.Package
import com.revenuecat.purchases.PurchaseParams
import com.revenuecat.purchases.Purchases
import com.revenuecat.purchases.PurchasesError
import com.revenuecat.purchases.getOfferingsWith
import com.revenuecat.purchases.interfaces.PurchaseCallback
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
import com.revenuecat.purchases.logInWith
import com.revenuecat.purchases.logOutWith
import com.revenuecat.purchases.models.StoreTransaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RevenueRepository {

    private val _isAdsRemoved = MutableStateFlow(false)
    val isAdsRemoved: StateFlow<Boolean> = _isAdsRemoved

    init {
        refreshCustomerInfo()
    }

    // Cambiamos a una forma más compatible de forzar el refresco
    fun refreshCustomerInfo() {
        // Invalidamos la caché local para forzar que el siguiente getCustomerInfo consulte al servidor
        Purchases.sharedInstance.invalidateCustomerInfoCache()
        
        Purchases.sharedInstance.getCustomerInfo(object : ReceiveCustomerInfoCallback {
            override fun onReceived(customerInfo: CustomerInfo) {
                _isAdsRemoved.value = customerInfo.entitlements["premium"]?.isActive == true
            }

            override fun onError(error: PurchasesError) {
                // Manejar error si es necesario
            }
        })
    }

    fun logIn(appUserId: String) {
        Purchases.sharedInstance.logInWith(
            appUserId,
            onSuccess = { customerInfo, _ ->
                _isAdsRemoved.value = customerInfo.entitlements["premium"]?.isActive == true
            },
            onError = { error -> }
        )
    }

    fun logOut() {
        Purchases.sharedInstance.logOutWith(
            onSuccess = { customerInfo ->
                _isAdsRemoved.value = customerInfo.entitlements["premium"]?.isActive == true
            },
            onError = { error -> }
        )
    }

    fun purchasePackage(activity: Activity, packageToPurchase: Package, onResult: (Boolean) -> Unit) {
        Purchases.sharedInstance.purchase(
            PurchaseParams.Builder(activity, packageToPurchase).build(),
            object : PurchaseCallback {
                override fun onCompleted(storeTransaction: StoreTransaction, customerInfo: CustomerInfo) {
                    if (customerInfo.entitlements["premium"]?.isActive == true) {
                        _isAdsRemoved.value = true
                        onResult(true)
                    }
                }
                override fun onError(error: PurchasesError, userCancelled: Boolean) {
                    onResult(false)
                }
            }
        )
    }

    fun getOfferings(onResult: (List<Package>) -> Unit) {
        Purchases.sharedInstance.getOfferingsWith(
            onError = { onResult(emptyList()) },
            onSuccess = { offerings ->
                val packages = offerings.current?.availablePackages ?: emptyList()
                onResult(packages)
            }
        )
    }
    
    fun restorePurchases() {
        Purchases.sharedInstance.restorePurchases(object : ReceiveCustomerInfoCallback {
            override fun onReceived(customerInfo: CustomerInfo) {
                _isAdsRemoved.value = customerInfo.entitlements["premium"]?.isActive == true
            }
            override fun onError(error: PurchasesError) {}
        })
    }
}
