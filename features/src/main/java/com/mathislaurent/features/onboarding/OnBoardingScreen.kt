package com.mathislaurent.features.onboarding

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnBoardingScreen(
    onBoardingViewModel: OnBoardingViewModel = koinViewModel(),
    navigateToHome: () -> Unit
) {
    OnBoardingContent(
        list = onBoardingViewModel.onBoardingSteps,
        onFinish = {
            onBoardingViewModel.onFinish()
            navigateToHome()
        }
    )
}