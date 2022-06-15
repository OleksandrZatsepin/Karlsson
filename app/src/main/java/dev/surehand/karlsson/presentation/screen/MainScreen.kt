package dev.surehand.karlsson.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.surehand.karlsson.R
import dev.surehand.karlsson.presentation.component.ImageCard

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = {
                        Text(text = stringResource(R.string.daily_thought))
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }

        ) {
            values ->
            LazyColumn(contentPadding = values) {
                items(20) {
                    ImageCard(
//                        title = title,
//                        description = description,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}