package com.sychev.kmp_sample.android.app

import android.app.Application
import com.sychev.kmp_sample.shared.di.KoinSetup
import org.koin.android.ext.koin.androidContext

class KmpSampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinSetup().apply {
            initKoin {
                androidContext(this@KmpSampleApp)
            }
        }

    }

}