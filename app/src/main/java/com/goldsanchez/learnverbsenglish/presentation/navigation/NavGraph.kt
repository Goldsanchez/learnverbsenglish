package com.goldsanchez.learnverbsenglish.presentation.navigation

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.goldsanchez.learnverbsenglish.data.BillingRepository
import com.goldsanchez.learnverbsenglish.presentation.IrregularVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.PhrasalVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.screens.*

@Composable
fun NavGraph(tts: TextToSpeech?) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val billingRepository = BillingRepository(context.applicationContext)

    NavHost(navController = navController, startDestination = "categories") {
        composable("categories") {
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(billingRepository = billingRepository) as T
                    }
                }
            )
            CategoryScreen(
                viewModel = viewModel,
                onIrregularClick = { navController.navigate("irregular_list") },
                onPhrasalClick = { navController.navigate("phrasal_list") }
            )
        }
        
        // Irregular Verbs Flow
        composable("irregular_list") {
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(billingRepository = billingRepository) as T
                    }
                }
            )
            ScreenA(
                viewModel = viewModel, 
                onBack = { navController.popBackStack() },
                onVerbClick = { index ->
                    navController.navigate("irregular_detail/$index")
                }
            )
        }
        composable(
            "irregular_detail/{verbIndex}",
            arguments = listOf(navArgument("verbIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("verbIndex") ?: 0
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(billingRepository = billingRepository) as T
                    }
                }
            )
            ScreenB(
                verbIndex = index,
                viewModel = viewModel,
                tts = tts,
                onBack = { navController.popBackStack() },
                onNavigate = { newIndex ->
                    navController.navigate("irregular_detail/$newIndex") {
                        popUpTo("irregular_list")
                    }
                }
            )
        }

        // Phrasal Verbs Flow
        composable("phrasal_list") {
            val viewModel: PhrasalVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return PhrasalVerbViewModel(billingRepository = billingRepository) as T
                    }
                }
            )
            PhrasalScreenA(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onVerbClick = { index ->
                    navController.navigate("phrasal_detail/$index")
                }
            )
        }
        composable(
            "phrasal_detail/{verbIndex}",
            arguments = listOf(navArgument("verbIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("verbIndex") ?: 0
            val viewModel: PhrasalVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return PhrasalVerbViewModel(billingRepository = billingRepository) as T
                    }
                }
            )
            PhrasalScreenB(
                verbIndex = index,
                viewModel = viewModel,
                tts = tts,
                onBack = { navController.popBackStack() },
                onNavigate = { newIndex ->
                    navController.navigate("phrasal_detail/$newIndex") {
                        popUpTo("phrasal_list")
                    }
                }
            )
        }
    }
}
