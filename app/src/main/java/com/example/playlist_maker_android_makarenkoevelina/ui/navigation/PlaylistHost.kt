package com.example.playlist_maker_android_makarenkoevelina.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.playlist_maker_android_makarenkoevelina.ui.main.MainScreen
import com.example.playlist_maker_android_makarenkoevelina.ui.search.SearchScreen
import com.example.playlist_maker_android_makarenkoevelina.ui.settings.SettingsActions
import com.example.playlist_maker_android_makarenkoevelina.ui.settings.SettingsScreen

@Composable
fun PlaylistHost(navController: NavHostController) {
    fun navigateTo(screen: PlaylistScreen) {
        navController.navigate(screen.route)
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    NavHost(
        navController = navController,
        startDestination = PlaylistScreen.MAIN.route
    ) {
        composable(PlaylistScreen.MAIN.route) {
            MainScreen(
                onSearchClick = { navigateTo(PlaylistScreen.SEARCH) },
                onSettingsClick = { navigateTo(PlaylistScreen.SETTINGS) }
            )
        }
        composable(PlaylistScreen.SEARCH.route) {
            SearchScreen(onBackClick = ::navigateBack)
        }
        composable(PlaylistScreen.SETTINGS.route) {
            val context = LocalContext.current
            val actions = remember(context) { SettingsActions(context) }
            SettingsScreen(
                onBackClick = ::navigateBack,
                onShareClick = actions::shareApp,
                onSupportClick = actions::contactDevelopers,
                onAgreementClick = actions::openAgreement
            )
        }
    }
}
