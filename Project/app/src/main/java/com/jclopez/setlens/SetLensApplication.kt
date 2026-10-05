package com.jclopez.setlens

import android.app.Application
import com.jclopez.setlens.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SetLensApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SetLensApplication)
            modules(appModule)
        }
    }
}
