package com.appknot.mentore

import android.app.Application
import com.appknot.mentore.di.appContext
import com.appknot.mentore.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

/**
 *
 * @author Ethan on 2022-01-26
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidFileProperties()
            modules(listOf(
                appContext,
                viewModelModule
            ))
        }
    }

}