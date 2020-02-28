package com.rastko.emplate_interview

import android.app.Application
import com.rastko.emplate_interview.core.coreModule
import com.rastko.emplate_interview.data.dataModule
import com.rastko.emplate_interview.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initKoin()
    }

    private fun initKoin() {
        val modules = dataModule + coreModule + uiModule

        startKoin {
            androidContext(this@App)
            androidLogger(Level.ERROR)
            modules(modules)
        }
    }
}