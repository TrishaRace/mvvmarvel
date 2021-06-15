package com.example.mvvmarvel

import android.app.Application
import com.example.characters.di.*
import com.example.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@AndroidApplication)
            modules(
                getModules()
            )
        }
    }

    private fun getModules() = mutableListOf(
        characterUseCasesModule,
        characterDataSourceModule,
        characterRepositoryModule,
        characterServiceModule,
        charactersViewModel,
        networkModule
    )
}