package com.mathislaurent.data.di

import com.mathislaurent.core.di.IO_DISPATCHER_NAME
import com.mathislaurent.data.datasource.local.LocalPhotoDataSource
import com.mathislaurent.data.datasource.remote.FakeRemotePhotoService
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataSourceModule = module {
    single { LocalPhotoDataSource(androidContext(), get(named(IO_DISPATCHER_NAME))) }
    single { FakeRemotePhotoService(get(named(IO_DISPATCHER_NAME))) }
}