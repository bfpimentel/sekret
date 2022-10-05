package dev.pimentel.sekret

import android.app.Application
import dev.pimentel.sekret.di.SekretKoin
import dev.pimentel.sekret.di.SekretModule
import org.koin.core.context.startKoin

class SekretApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val koinInstance = startKoin {
            modules(SekretModule.module)
        }

        SekretKoin.initialize(koinInstance)
    }
}
