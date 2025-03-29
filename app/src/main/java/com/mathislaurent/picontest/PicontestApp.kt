package com.mathislaurent.picontest

import android.app.Application
import org.koin.core.context.startKoin

class PicontestApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

        }
    }
}