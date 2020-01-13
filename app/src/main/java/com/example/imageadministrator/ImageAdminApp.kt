package com.example.imageadministrator

import android.app.Application
import com.example.imageadministrator.di.appModule
import com.example.imageadministrator.di.coreModule
import com.example.imageadministrator.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * InitialValues is where the database and api are instantiated and can be used from other activities
 */
class ImageAdminApp : Application() {

    override fun onCreate() {

        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ImageAdminApp)
            androidFileProperties()
            modules(listOf(appModule, dataModule, coreModule))
        }
    }
}