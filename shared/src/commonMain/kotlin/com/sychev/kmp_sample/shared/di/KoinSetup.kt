package com.sychev.kmp_sample.shared.di

import org.koin.core.KoinApplication
import org.koin.core.module.Module

expect class KoinSetup {
    fun initKoin(modules: List<Module> = emptyList()): KoinApplication
}