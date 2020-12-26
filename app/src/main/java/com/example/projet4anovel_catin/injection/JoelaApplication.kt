package com.example.projet4anovel_catin.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JoelaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@JoelaApplication)
            // modules
            modules(presentationModule, domainModule, dataModule)
        }
    }
}