package dev.surehand.karlsson.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.surehand.karlsson.presentation.navigation.SetupNavGraph
import dev.surehand.karlsson.presentation.ui.theme.KarlssonTheme

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KarlssonTheme() {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }

}
