package com.mathislaurent.data.di

import com.mathislaurent.core.di.IO_DISPATCHER_NAME
import com.mathislaurent.data.repository.CameraRepositoryImpl
import com.mathislaurent.data.repository.OnBoardingRepositoryImpl
import com.mathislaurent.data.repository.PhotoRepositoryImpl
import com.mathislaurent.domain.repository.CameraRepository
import com.mathislaurent.domain.repository.OnBoardingRepository
import com.mathislaurent.domain.repository.PhotoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<OnBoardingRepository> { OnBoardingRepositoryImpl(get(), get(named(IO_DISPATCHER_NAME))) }
    single<CameraRepository> { CameraRepositoryImpl(androidContext(), get(named(IO_DISPATCHER_NAME))) }
    single<PhotoRepository> { PhotoRepositoryImpl(get(named(IO_DISPATCHER_NAME))) }
}