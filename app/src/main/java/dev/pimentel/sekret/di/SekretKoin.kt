package dev.pimentel.sekret.di

import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent

object SekretKoin : KoinComponent {
    internal var koinApplication: KoinApplication? = null

    fun initialize(koinApplication: KoinApplication) {
        this.koinApplication = koinApplication
    }
}

interface SekretKoinComponent : KoinComponent {
    override fun getKoin(): Koin = SekretKoin.koinApplication?.koin
        ?: throw IllegalStateException("Koin has not been initialized.")
}


