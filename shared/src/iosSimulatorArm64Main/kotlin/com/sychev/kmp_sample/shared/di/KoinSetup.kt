package com.sychev.kmp_sample.shared.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

actual class KoinSetup {

    actual fun initKoin(appDeclaration: KoinAppDeclaration): KoinApplication = startKoin {
        TODO()
    }

}
