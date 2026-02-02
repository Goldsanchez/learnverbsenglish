package com.goldsanchez.learnverbsenglish.presentation.navigation

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.goldsanchez.learnverbsenglish.data.AuthRepository
import com.goldsanchez.learnverbsenglish.data.ProgressRepository
import com.goldsanchez.learnverbsenglish.data.RevenueRepository
import com.goldsanchez.learnverbsenglish.presentation.AuthViewModel
import com.goldsanchez.learnverbsenglish.presentation.FlashcardViewModel
import com.goldsanchez.learnverbsenglish.presentation.IrregularVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.PhrasalVerbViewModel
import com.goldsanchez.learnverbsenglish.presentation.StoryViewModel
import com.goldsanchez.learnverbsenglish.presentation.screens.*

@Composable
fun NavGraph(
    tts: TextToSpeech?, 
    revenueRepository: RevenueRepository,
    authRepository: AuthRepository,
    progressRepository: ProgressRepository
) {
    val navController = rememberNavController()
    val isAdsRemoved by revenueRepository.isAdsRemoved.collectAsState()

    NavHost(navController = navController, startDestination = "categories") {
        composable("login") {
            val authViewModel: AuthViewModel = viewModel(factory = object : ViewModelProvider.Factory { override fun <T : ViewModel> create(modelClass: Class<T>): T = AuthViewModel(authRepository) as T })
            LoginScreen(viewModel = authViewModel, onLoginSuccess = { navController.navigate("categories") { popUpTo("login") { inclusive = true } } }, onNavigateToSignUp = { navController.navigate("signup") })
        }

        composable("signup") {
            val authViewModel: AuthViewModel = viewModel(factory = object : ViewModelProvider.Factory { override fun <T : ViewModel> create(modelClass: Class<T>): T = AuthViewModel(authRepository) as T })
            SignUpScreen(viewModel = authViewModel, onSignUpSuccess = { navController.navigate("categories") { popUpTo("login") { inclusive = true } } }, onNavigateToLogin = { navController.popBackStack() } )
        }

        composable("categories") {
            val irregularViewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(revenueRepository = revenueRepository, authRepository = authRepository, progressRepository = progressRepository) as T
                    }
                }
            )
            val phrasalViewModel: PhrasalVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return PhrasalVerbViewModel(repository = com.goldsanchez.learnverbsenglish.data.PhrasalVerbRepositoryImpl(), revenueRepository = revenueRepository, progressRepository = progressRepository, authRepository = authRepository) as T
                    }
                }
            )
            val storyViewModel: StoryViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return StoryViewModel(progressRepository = progressRepository, authRepository = authRepository) as T
                    }
                }
            )
            
            val phrasalLearned by phrasalViewModel.learnedVerbs.collectAsState()
            val phrasalLearnedCount = phrasalLearned.intersect(phrasalViewModel.phrasalVerbs.map { it.verb }.toSet()).size

            val completedStories by storyViewModel.completedStories.collectAsState()

            CategoryScreen(
                viewModel = irregularViewModel,
                phrasalLearnedCount = phrasalLearnedCount,
                phrasalTotalCount = phrasalViewModel.phrasalVerbs.size,
                storiesLearnedCount = completedStories.size,
                storiesTotalCount = storyViewModel.stories.size,
                onIrregularClick = { navController.navigate("irregular_list") },
                onPhrasalClick = { navController.navigate("phrasal_list") },
                onProfileClick = { if (authRepository.currentUser.value == null) navController.navigate("login") else navController.navigate("profile") },
                onStoriesClick = { navController.navigate("story_list") },
                onQuickLearnClick = { navController.navigate("quick_learn") }
            )
        }
        
        composable("quick_learn") {
            val flashViewModel: FlashcardViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return FlashcardViewModel(
                            progressRepository = progressRepository,
                            authRepository = authRepository
                        ) as T
                    }
                }
            )
            FlashcardScreen(
                viewModel = flashViewModel,
                isAdsRemoved = isAdsRemoved,
                tts = tts,
                onBack = { navController.popBackStack() }
            )
        }
        
        composable("story_list") {
            val storyViewModel: StoryViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return StoryViewModel(progressRepository = progressRepository, authRepository = authRepository) as T
                    }
                }
            )
            val isPremium by revenueRepository.isAdsRemoved.collectAsState()
            StoryListScreen(
                viewModel = storyViewModel,
                isPremium = isPremium,
                onBack = { navController.popBackStack() },
                onStoryClick = { id -> navController.navigate("story_detail/$id") },
                onPayClick = { navController.navigate("categories") }
            )
        }

        composable(
            "story_detail/{storyId}",
            arguments = listOf(navArgument("storyId") { type = NavType.StringType })
        ) { backStackEntry ->
            val storyId = backStackEntry.arguments?.getString("storyId") ?: ""
            val storyViewModel: StoryViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return StoryViewModel(progressRepository = progressRepository, authRepository = authRepository) as T
                    }
                }
            )
            StoryDetailScreen(
                storyId = storyId,
                viewModel = storyViewModel,
                isAdsRemoved = isAdsRemoved,
                tts = tts,
                onBack = { navController.popBackStack() }
            )
        }

        composable("profile") {
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(revenueRepository = revenueRepository, authRepository = authRepository, progressRepository = progressRepository) as T
                    }
                }
            )
            ProfileScreen(viewModel = viewModel, onBack = { navController.popBackStack() }, onLogout = { navController.navigate("categories") { popUpTo(0) { inclusive = true } } })
        }
        
        composable("irregular_list") {
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(revenueRepository = revenueRepository, authRepository = authRepository, progressRepository = progressRepository) as T
                    }
                }
            )
            ScreenA(viewModel = viewModel, onBack = { navController.popBackStack() }, onVerbClick = { index -> navController.navigate("irregular_detail/$index") })
        }
        composable("irregular_detail/{verbIndex}", arguments = listOf(navArgument("verbIndex") { type = NavType.IntType })) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("verbIndex") ?: 0
            val viewModel: IrregularVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return IrregularVerbViewModel(revenueRepository = revenueRepository, authRepository = authRepository, progressRepository = progressRepository) as T
                    }
                }
            )
            ScreenB(verbIndex = index, viewModel = viewModel, tts = tts, onBack = { navController.popBackStack() })
        }
        composable("phrasal_list") {
            val viewModel: PhrasalVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return PhrasalVerbViewModel(revenueRepository = revenueRepository, progressRepository = progressRepository, authRepository = authRepository) as T
                    }
                }
            )
            PhrasalScreenA(viewModel = viewModel, onBack = { navController.popBackStack() }, onVerbClick = { index -> navController.navigate("phrasal_detail/$index") })
        }
        composable("phrasal_detail/{verbIndex}", arguments = listOf(navArgument("verbIndex") { type = NavType.IntType })) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("verbIndex") ?: 0
            val viewModel: PhrasalVerbViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return PhrasalVerbViewModel(revenueRepository = revenueRepository, progressRepository = progressRepository, authRepository = authRepository) as T
                    }
                }
            )
            PhrasalScreenB(verbIndex = index, viewModel = viewModel, tts = tts, onBack = { navController.popBackStack() })
        }
    }
}
