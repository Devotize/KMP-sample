package com.sychev.kmp_sample.shared.di

import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration

expect class KoinSetup {
    fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication
}