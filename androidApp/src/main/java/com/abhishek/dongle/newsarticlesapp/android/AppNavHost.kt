package com.abhishek.dongle.newsarticlesapp.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhishek.dongle.newsarticlesapp.android.screens.ArticlesScreen
import com.abhishek.dongle.newsarticlesapp.android.screens.Screens
import com.abhishek.dongle.newsarticlesapp.android.screens.SettingsScreen
import com.abhishek.dongle.newsarticlesapp.article.ArticlesViewModel

@Composable
fun AppNavHost(
    viewModel: ArticlesViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onSettingsClicked = { navController.navigate(Screens.SETTINGS.route) },
                articleViewModel = viewModel
            )
        }
        composable(Screens.SETTINGS.route) {
            SettingsScreen()
        }
    }
}