package dev.surehand.karlsson.presentation.navigation

const val ROOT_GRAPH_ROUTE = "root"
const val SPLASH_GRAPH_ROUTE = "splash"

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash_screen")
    object Main : Screen(route = "main_screen")
}