# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Optimización para Jetpack Compose
-keepclassmembers class androidx.compose.ui.platform.InspectableValue {
   private java.lang.Object element;
}

# --- REVENUECAT ---
# Reglas necesarias para que la facturación con RevenueCat no se rompa al ofuscar
-keep class com.revenuecat.purchases.** { *; }
-dontwarn com.revenuecat.purchases.**

# --- GOOGLE PLAY BILLING ---
# Conservar clases de Google Play Billing (RevenueCat lo usa internamente)
-keep class com.android.billingclient.** { *; }
-dontwarn com.android.billingclient.**

# --- FIREBASE & GOOGLE SERVICES ---
# Firebase Auth y servicios de Google
-keepattributes Signature, *Annotation*, EnclosingMethod, InnerClasses
-keep public class com.google.firebase.** { *; }
-keep public class com.google.android.gms.** { *; }
-dontwarn com.google.firebase.**
-dontwarn com.google.android.gms.**

# --- ADMOB ---
# Conservar clases de AdMob para que los anuncios se carguen correctamente
-keep class com.google.android.gms.ads.** { *; }
-keep class com.google.ads.** { *; }

# --- KOTLIN COROUTINES ---
# Necesario si usas corrutinas (Firebase y RevenueCat las usan)
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepnames class kotlinx.coroutines.android.AndroidExceptionPreHandler {}
-keepnames class kotlinx.coroutines.android.AndroidDispatcherFactory {}
-dontwarn kotlinx.coroutines.**

# Mantener los nombres de los modelos de datos si se usan para serialización (JSON)
# Si tus clases Verb o PhrasalVerb se usan con Firebase Realtime/Firestore o Gson:
-keepclassmembers class com.goldsanchez.learnverbsenglish.domain.model.** { *; }
