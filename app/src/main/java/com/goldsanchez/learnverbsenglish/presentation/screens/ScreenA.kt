package com.goldsanchez.learnverbsenglish.presentation.screens

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.WorkspacePremium
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldsanchez.learnverbsenglish.domain.model.Verb
import com.goldsanchez.learnverbsenglish.presentation.VerbViewModel
import com.goldsanchez.learnverbsenglish.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenA(viewModel: VerbViewModel, onVerbClick: (Int) -> Unit) {
    val isAdsRemoved by viewModel.isAdsRemoved.collectAsState()
    val context = LocalContext.current
    var showPayDialog by remember { mutableStateOf(false) }

    if (showPayDialog) {
        AlertDialog(
            onDismissRequest = { showPayDialog = false },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { showPayDialog = false }, modifier = Modifier.fillMaxWidth()) {
                    Text("Cerrar", color = Color.Gray)
                }
            },
            icon = { 
                Icon(
                    Icons.Rounded.WorkspacePremium, 
                    contentDescription = null, 
                    tint = if (isAdsRemoved) Color(0xFFFFD700) else AccentColor, 
                    modifier = Modifier.size(48.dp)
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
                    if (isAdsRemoved) {
                        Text("¡Ya eres miembro Premium! Disfrutas de una experiencia sin anuncios y apoyas el proyecto.", fontSize = 14.sp, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.height(24.dp))
                        Button(
                            onClick = {
                                val packageName = context.packageName
                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                    data = Uri.parse("https://play.google.com/store/account/subscriptions?package=$packageName")
                                }
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray.copy(alpha = 0.2f), contentColor = PrimaryColor),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Gestionar o Cancelar Suscripción", fontSize = 13.sp)
                        }
                    } else {
                        Text("Estudia sin interrupciones y apoya el proyecto.", fontSize = 14.sp, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.height(20.dp))
                        
                        SubscriptionOption(
                            title = "Plan Mensual",
                            price = "$0.99 USD",
                            subtitle = "Cobro cada mes",
                            onClick = {
                                showPayDialog = false
                                viewModel.removeAds(context as Activity, "sub_monthly")
                            }
                        )
                        
                        Spacer(modifier = Modifier.height(12.dp))
                        
                        SubscriptionOption(
                            title = "Plan Anual",
                            price = "$4.99 USD",
                            subtitle = "¡Ahorra más del 50%!",
                            isHighlight = true,
                            onClick = {
                                showPayDialog = false
                                viewModel.removeAds(context as Activity, "sub_yearly")
                            }
                        )
                    }
                }
            },
            shape = RoundedCornerShape(28.dp),
            containerColor = Color.White
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            "Verbos Irregulares", 
                            fontWeight = FontWeight.SemiBold, 
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                        
                        if (isAdsRemoved) {
                            // Solo el icono dorado al final del lado derecho
                            IconButton(
                                onClick = { showPayDialog = true },
                                modifier = Modifier.align(Alignment.CenterEnd)
                            ) {
                                Icon(
                                    Icons.Rounded.WorkspacePremium, 
                                    contentDescription = "Gestionar Suscripción", 
                                    tint = Color(0xFFFFD700), // Gold color
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                },
                actions = {
                    if (!isAdsRemoved) {
                        IconButton(onClick = { showPayDialog = true }) {
                            Icon(
                                Icons.Rounded.WorkspacePremium, 
                                contentDescription = "Suscripción", 
                                tint = Color.White.copy(alpha = 0.7f)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AccentColor
                )
            )
        },
        containerColor = BackgroundColor
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = viewModel.searchQuery,
                onValueChange = { viewModel.onSearchQueryChange(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Buscar verbo...", color = Color.Gray) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = AccentColor) },
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AccentColor,
                    unfocusedBorderColor = Color.LightGray
                ),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(bottom = 20.dp)
            ) {
                itemsIndexed(viewModel.filteredVerbs) { _, verb ->
                    val actualIndex = viewModel.verbs.indexOf(verb)
                    VerbItem(verb, actualIndex, onVerbClick)
                }
            }
        }
    }
}

@Composable
fun SubscriptionOption(title: String, price: String, subtitle: String, isHighlight: Boolean = false, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        color = if (isHighlight) AccentColor.copy(alpha = 0.05f) else Color.White,
        border = BorderStroke(2.dp, if (isHighlight) AccentColor else Color.LightGray.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = PrimaryColor)
                Text(subtitle, fontSize = 12.sp, color = if (isHighlight) AccentColor else Color.Gray)
            }
            Text(price, fontWeight = FontWeight.Black, fontSize = 18.sp, color = AccentColor)
        }
    }
}

@Composable
fun VerbItem(verb: Verb, index: Int, onClick: (Int) -> Unit) {
    val bgColor = ColorList[index % ColorList.size]
    
    Surface(
        onClick = { onClick(index) },
        shape = RoundedCornerShape(16.dp),
        color = bgColor,
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = verb.infinitive,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor
                )
                Text(
                    text = verb.translation,
                    fontSize = 14.sp,
                    color = SpanishTextColor
                )
            }
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = PrimaryColor.copy(alpha = 0.6f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
