package com.sychev.kmp_sample.shared.di

import com.sychev.kmp_sample.backend.impl.di.backendModule
import di.newsModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(backendModule(), newsModule())
}