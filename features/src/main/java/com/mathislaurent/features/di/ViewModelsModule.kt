package com.mathislaurent.features.di

import com.mathislaurent.features.camera.CameraViewModel
import com.mathislaurent.features.launcher.LauncherViewModel
import com.mathislaurent.features.onboarding.OnBoardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { LauncherViewModel(get()) }
    viewModel { OnBoardingViewModel(get()) }
    viewModel { CameraViewModel(get()) }
}