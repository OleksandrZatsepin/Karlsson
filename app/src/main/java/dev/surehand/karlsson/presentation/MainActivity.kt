package dev.surehand.karlsson.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.surehand.karlsson.presentation.navigation.SetupNavGraph
import dev.surehand.karlsson.presentation.ui.theme.KarlssonTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
//    private val mainViewModel: MainViewModel by viewModels()

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
