package com.mathislaurent.features.home.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    openCamera: () -> Unit
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        NavigationBarItem(
            selected = selectedNavigationIndex.value == 0,
            onClick = {
                selectedNavigationIndex.value = 0
                navController.navigate(HomeNavigationItems.WelcomeNavItem.screenRoute)
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.surface,
                indicatorColor = MaterialTheme.colorScheme.primary
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                openCamera()
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Camera"
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.surface,
                indicatorColor = MaterialTheme.colorScheme.primary
            )

        )

        NavigationBarItem(
            selected = selectedNavigationIndex.value == 2,
            onClick = {
                selectedNavigationIndex.value = 2
                navController.navigate(HomeNavigationItems.RankingNavItem.screenRoute)
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Ranking"
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.surface,
                indicatorColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}