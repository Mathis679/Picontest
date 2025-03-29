package com.mathislaurent.features.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.mathislaurent.features.camera.CameraActivity
import com.mathislaurent.features.home.navigation.BottomNavigationBar
import com.mathislaurent.features.home.navigation.HomeNavigationGraph

@Composable
fun HomeScreen(
    openContest: () -> Unit
) {
    val navController = rememberNavController()
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                openCamera = {
                    context.startActivity(
                        CameraActivity.newIntent(context)
                    )
                }
            )
        }
    ) { innerPadding ->
        HomeNavigationGraph(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            openContest = openContest
        )
    }
}