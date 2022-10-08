package dev.pimentel.sekret.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.module.Module

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

@Composable
inline fun <reified T : Any> sekretKoinGet(): T = remember { SekretKoin.getKoin().get() }

fun Koin.loadModule(module: Module) {
    loadModules(listOf(module))
}


