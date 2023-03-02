package com.sychev.kmp_sample.android.app

import android.app.Application
import com.impl.feature.backend.di.backendModule
import com.impl.feature.news.di.newsModule
import com.sychev.kmp_sample.shared.di.KoinSetup
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

class KmpSampleApp : Application() {

    private val sharedModules: List<Module> = listOf(
        module { single { applicationContext } },
        backendModule(),
        newsModule(),
    )

    override fun onCreate() {
        super.onCreate()
        KoinSetup().apply {
            initKoin(
                sharedModules
            )
        }

    }

}