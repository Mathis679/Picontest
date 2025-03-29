package com.mathislaurent.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.mathislaurent.designsystem.ui.theme.PicontestTheme
import com.mathislaurent.features.navigation.MainNavigationGraph
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinContext {
                PicontestTheme {
                    MainNavigationGraph(
                        navController = rememberNavController()
                    )
                }
            }
        }
    }
}