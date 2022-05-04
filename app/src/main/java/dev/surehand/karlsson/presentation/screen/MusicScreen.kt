package dev.surehand.karlsson.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MusicScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Music Screen",
            style = MaterialTheme.typography.h1
        )
    }
}