package com.goldsanchez.learnverbsenglish.presentation.navigation

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.goldsanchez.learnverbsenglish.data.AuthRepository
import com.goldsanchez.learnverbsenglish.data.RevenueRepository
import com.goldsanchez.learnverbsenglish.presentation.AuthViewModel
import com.goldsanchez.learnverbsenglish.presentation.IrregularVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.PhrasalVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.screens.*

@Composable
fun NavGraph(
    tts: TextToSpeech?, 
    revenueRepository: RevenueRepository,
    authRepository: AuthRepository
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, 
        startDestination = "categories" // La app inicia siempre en categorías
    ) {
        composable("login") {
            val authViewModel: AuthViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return AuthViewModel(authRepository) as T
                    }
                }
            )
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = { 
                    navController.navigate("categories") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToSignUp = { navController.navigate("signup") }
            )
        }

        composable("signup") {
            val authViewModel: AuthViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return AuthViewModel(authRepository) as T
                    }
                }
            )
            SignUpScreen(
                viewModel = authViewModel,
                onSignUpSuccess = {
                    navController.navigate("categories") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToLogin = { navController.popBackStack() }
            )
        }

        composable("categories") {
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(
                            revenueRepository = revenueRepository,
                            authRepository = authRepository
                        ) as T
                    }
                }
            )
            CategoryScreen(
                viewModel = viewModel,
                onIrregularClick = { navController.navigate("irregular_list") },
                onPhrasalClick = { navController.navigate("phrasal_list") },
                onProfileClick = { 
                    // Si el usuario no está logueado, lo mandamos al login, si no, al perfil
                    if (authRepository.currentUser.value == null) {
                        navController.navigate("login")
                    } else {
                        navController.navigate("profile")
                    }
                }
            )
        }
        
        composable("profile") {
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(
                            revenueRepository = revenueRepository,
                            authRepository = authRepository
                        ) as T
                    }
                }
            )
            ProfileScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate("categories") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
        
        // ... (resto de rutas de listas y detalles igual)
        composable("irregular_list") {
            val viewModel: IrregularVerbViewModel = viewModel(factory = object : ViewModelProvider.Factory { override fun <T : ViewModel> create(modelClass: Class<T>): T = IrregularVerbViewModel(revenueRepository = revenueRepository, authRepository = authRepository) as T })
            ScreenA(viewModel = viewModel, onBack = { navController.popBackStack() }, onVerbClick = { index -> navController.navigate("irregular_detail/$index") })
        }
        composable("irregular_detail/{verbIndex}", arguments = listOf(navArgument("verbIndex") { type = NavType.IntType })) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("verbIndex") ?: 0
            val viewModel: IrregularVerbViewModel = viewModel(factory = object : ViewModelProvider.Factory { override fun <T : ViewModel> create(modelClass: Class<T>): T = IrregularVerbViewModel(revenueRepository = revenueRepository, authRepository = authRepository) as T })
            ScreenB(verbIndex = index, viewModel = viewModel, tts = tts, onBack = { navController.popBackStack() }, onNavigate = { newIndex -> navController.navigate("irregular_detail/$newIndex") { popUpTo("irregular_list") } })
        }
        composable("phrasal_list") {
            val viewModel: PhrasalVerbViewModel = viewModel(factory = object : ViewModelProvider.Factory { override fun <T : ViewModel> create(modelClass: Class<T>): T = PhrasalVerbViewModel(revenueRepository = revenueRepository) as T })
            PhrasalScreenA(viewModel = viewModel, onBack = { navController.popBackStack() }, onVerbClick = { index -> navController.navigate("phrasal_detail/$index") })
        }
        composable("phrasal_detail/{verbIndex}", arguments = listOf(navArgument("verbIndex") { type = NavType.IntType })) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("verbIndex") ?: 0
            val viewModel: PhrasalVerbViewModel = viewModel(factory = object : ViewModelProvider.Factory { override fun <T : ViewModel> create(modelClass: Class<T>): T = PhrasalVerbViewModel(revenueRepository = revenueRepository) as T })
            PhrasalScreenB(verbIndex = index, viewModel = viewModel, tts = tts, onBack = { navController.popBackStack() }, onNavigate = { newIndex -> navController.navigate("phrasal_detail/$newIndex") { popUpTo("phrasal_list") } })
        }
    }
}
