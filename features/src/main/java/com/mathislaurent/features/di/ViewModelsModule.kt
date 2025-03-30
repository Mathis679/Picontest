package com.mathislaurent.features.di

import com.mathislaurent.features.camera.CameraViewModel
import com.mathislaurent.features.contest.ContestViewModel
import com.mathislaurent.features.contest.rate.RateViewModel
import com.mathislaurent.features.contest.select.SelectViewModel
import com.mathislaurent.features.home.ranking.RankingViewModel
import com.mathislaurent.features.launcher.LauncherViewModel
import com.mathislaurent.features.onboarding.OnBoardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { LauncherViewModel(get()) }
    viewModel { OnBoardingViewModel(get()) }
    viewModel { CameraViewModel(get()) }
    viewModel { ContestViewModel() }
    viewModel { SelectViewModel(get()) }
    viewModel { RateViewModel(get()) }
    viewModel { RankingViewModel(get()) }
}