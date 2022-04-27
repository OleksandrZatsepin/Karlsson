package dev.surehand.karlsson.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.surehand.karlsson.presentation.screen.MainScreen
import dev.surehand.karlsson.presentation.screen.SplashScreen

fun NavGraphBuilder.splashNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Splash.route,
        route = SPLASH_GRAPH_ROUTE
    ){
        composable(
            route = Screen.Splash.route
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screen.Main.route
        ) {
            MainScreen(navController = navController)
        }
    }
}