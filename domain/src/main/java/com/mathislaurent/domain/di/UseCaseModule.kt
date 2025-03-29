package com.mathislaurent.domain.di

import com.mathislaurent.core.di.DEFAULT_DISPATCHER_NAME
import com.mathislaurent.domain.usecase.camera.SaveBitmapUseCase
import com.mathislaurent.domain.usecase.onboarding.SetShowOnBoardingUseCase
import com.mathislaurent.domain.usecase.onboarding.ShouldShowOnBoardingUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    single { SetShowOnBoardingUseCase(get(), get(named(DEFAULT_DISPATCHER_NAME))) }
    single { ShouldShowOnBoardingUseCase(get(), get(named(DEFAULT_DISPATCHER_NAME))) }
    single { SaveBitmapUseCase(get(), get(named(DEFAULT_DISPATCHER_NAME))) }
}