package dev.surehand.karlsson.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Quote : BottomBarScreen(
        route = "quote",
        title = "Quote",
        icon = Icons.Default.List
    )

    object Music : BottomBarScreen(
        route = "music",
        title = "Music",
        icon = Icons.Default.PlayArrow
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}