package com.mathislaurent.features.launcher

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun LauncherScreen(
    viewModel: LauncherViewModel = koinViewModel(),
    navigateToHome: () -> Unit,
    navigateToOnBoarding: () -> Unit,
) {
    val navigateToState = viewModel.navigateTo.collectAsStateWithLifecycle().value
    val listenNavigation = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(navigateToState, listenNavigation.value) {
        if (listenNavigation.value) {
            when (navigateToState) {
                LauncherViewModel.NavigateTo.HOME -> navigateToHome()
                LauncherViewModel.NavigateTo.ON_BOARDING -> navigateToOnBoarding()
                else -> {
                    //do nothing
                }
            }
        }
    }

    LauncherContent(
        onContinue = {
            listenNavigation.value = true
            viewModel.clickOnContinue()
        }
    )
}