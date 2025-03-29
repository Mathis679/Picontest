package com.mathislaurent.core.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val IO_DISPATCHER_NAME = "IODispatcher"
const val DEFAULT_DISPATCHER_NAME = "DefaultDispatcher"
const val MAIN_DISPATCHER_NAME = "DefaultDispatcher"

val dispatchersModule = module {
    single(named(IO_DISPATCHER_NAME)) {
        Dispatchers.IO
    }

    single(named(DEFAULT_DISPATCHER_NAME)) {
        Dispatchers.Default
    }

    single(named(MAIN_DISPATCHER_NAME)) {
        Dispatchers.Main
    }
}