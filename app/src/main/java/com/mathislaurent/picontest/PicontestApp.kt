package com.mathislaurent.picontest

import android.app.Application
import com.mathislaurent.core.di.dispatchersModule
import com.mathislaurent.data.di.preferenceModule
import com.mathislaurent.data.di.repositoryModule
import com.mathislaurent.domain.di.useCaseModule
import com.mathislaurent.features.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class PicontestApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PicontestApp)
            modules(allModules())
        }
    }

    private fun allModules(): List<Module> {
        return listOf(
            dispatchersModule,
            viewModelsModule,
            preferenceModule,
            repositoryModule,
            useCaseModule
        )
    }

}