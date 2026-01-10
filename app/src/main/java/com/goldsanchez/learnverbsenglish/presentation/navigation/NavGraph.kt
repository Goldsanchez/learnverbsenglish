package com.goldsanchez.learnverbsenglish.presentation.navigation

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.goldsanchez.learnverbsenglish.presentation.VerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.screens.ScreenA
import com.goldsanchez.learnverbsenglish.presentation.screens.ScreenB

@Composable
fun NavGraph(viewModel: VerbViewModel, tts: TextToSpeech?) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(viewModel = viewModel, onVerbClick = { index ->
                navController.navigate("screenB/$index")
            })
        }
        composable(
            "screenB/{verbIndex}",
            arguments = listOf(navArgument("verbIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("verbIndex") ?: 0
            ScreenB(
                verbIndex = index,
                viewModel = viewModel,
                tts = tts,
                onBack = { navController.popBackStack() },
                onNavigate = { newIndex ->
                    navController.navigate("screenB/$newIndex") {
                        popUpTo("screenA")
                    }
                }
            )
        }
    }
}
