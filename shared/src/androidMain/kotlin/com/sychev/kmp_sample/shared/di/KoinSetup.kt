package com.sychev.kmp_sample.shared.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

actual class KoinSetup {

    actual fun initKoin(modules: List<Module>): KoinApplication = startKoin {
        modules(modules)
    }

}
