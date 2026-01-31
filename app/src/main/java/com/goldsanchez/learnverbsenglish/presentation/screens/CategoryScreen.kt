package com.goldsanchez.learnverbsenglish.presentation.screens

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.WorkspacePremium
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.presentation.IrregularVerbViewModel
import com.goldsanchez.learnverbsenglish.ui.theme.*
import com.revenuecat.purchases.Package

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    viewModel: IrregularVerbViewModel,
    onIrregularClick: () -> Unit,
    onPhrasalClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    val isAdsRemoved by viewModel.isAdsRemoved.collectAsState()
    val context = LocalContext.current
    var showPayDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    var offerings by remember { mutableStateOf<List<Package>>(emptyList()) }

    // Cargar ofertas de RevenueCat
    LaunchedEffect(Unit) {
        viewModel.getOfferings { list ->
            offerings = list
        }
    }

    // Función segura para cerrar el diálogo
    val closeDialog = { showPayDialog = false }

    // Función auxiliar para obtener Activity sin errores de casteo
    fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }

    if (showPayDialog) {
        AlertDialog(
            onDismissRequest = closeDialog,
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = closeDialog, modifier = Modifier.fillMaxWidth()) {
                    Text("Cerrar", color = Color.Gray)
                }
            },
            icon = { 
                Icon(
                    Icons.Rounded.WorkspacePremium, 
                    contentDescription = null, 
                    tint = if (isAdsRemoved) Color(0xFFFFD700) else AccentColor, 
                    modifier = Modifier.size(40.dp)
                ) 
            },
            title = { 
                Text(
                    if (isAdsRemoved) "Tu Plan Premium" else "Elige tu Plan Premium", 
                    fontWeight = FontWeight.Bold, 
                    textAlign = TextAlign.Center 
                ) 
            },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        if (isAdsRemoved) "¡Ya eres miembro Premium! Disfrutas de una experiencia sin anuncios y apoyas el proyecto."
                        else "Aprende sin anuncios. Tu suscripción ayuda a que la app siga mejorando cada día.", 
                        fontSize = 14.sp, 
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    if (isAdsRemoved) {
                        Button(
                            onClick = {
                                val packageName = context.packageName
                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                    data = Uri.parse("https://play.google.com/store/account/subscriptions?package=$packageName")
                                }
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray.copy(alpha = 0.2f), contentColor = Color(0xFF212121)),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Gestionar Suscripción")
                        }
                    } else {
                        // Dinámicamente mostrar paquetes de RevenueCat
                        offerings.forEach { pkg ->
                            SubscriptionOption(
                                title = pkg.product.title,
                                price = pkg.product.price.formatted,
                                subtitle = pkg.product.description,
                                isHighlight = pkg.identifier.contains("yearly", true),
                                onClick = {
                                    closeDialog()
                                    context.findActivity()?.let { activity ->
                                        viewModel.purchasePackage(activity, pkg)
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                        
                        if (offerings.isEmpty()) {
                            Text("Cargando planes...", color = Color.Gray, fontSize = 12.sp)
                        }
                    }
                }
            },
            shape = RoundedCornerShape(28.dp),
            containerColor = Color.White
        )
    }

    Scaffold(
        containerColor = Color(0xFFF8F9FA),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "English Mastery Verbs",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onProfileClick) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { showPayDialog = true }) {
                        Icon(
                            Icons.Rounded.WorkspacePremium,
                            contentDescription = "Premium",
                            tint = if (isAdsRemoved) Color(0xFFFFD700) else Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.size(26.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AccentColor
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = "¿Qué quieres aprender hoy?",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF1C1B1F),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
            
            Text(
                text = "Selecciona una categoría para comenzar",
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp)
            )

            // Categorías
            CategoryLearningCard(
                title = "Verbos Irregulares",
                description = "Domina las 3 formas fundamentales",
                icon = Icons.Default.AutoAwesome,
                accentColor = AccentColor,
                onClick = onIrregularClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            CategoryLearningCard(
                title = "Phrasal Verbs",
                description = "Los 100 más usados en contexto",
                icon = Icons.Default.MenuBook,
                accentColor = Color(0xFFE91E63),
                onClick = onPhrasalClick
            )
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun CategoryLearningCard(
    title: String,
    description: String,
    icon: ImageVector,
    accentColor: Color,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(28.dp),
        color = Color.White,
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(accentColor.copy(alpha = 0.1f), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(28.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C1B1F)
                    )
                )
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
            }
            
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = Color(0xFFE0E0E0),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun SubscriptionOption(title: String, price: String, subtitle: String, isHighlight: Boolean = false, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        color = if (isHighlight) Color(0xFFE8EAF6) else Color.White,
        border = BorderStroke(2.dp, if (isHighlight) AccentColor else Color(0xFFF0F2F5)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF1C1B1F))
                Text(subtitle, fontSize = 12.sp, color = if (isHighlight) AccentColor else Color.Gray)
            }
            Text(price, fontWeight = FontWeight.Black, fontSize = 18.sp, color = AccentColor)
        }
    }
}
