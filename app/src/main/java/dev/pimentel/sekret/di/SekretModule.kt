package dev.pimentel.sekret.di

import androidx.navigation.NavController
import dev.pimentel.sekret.navigation.DefaultSekretNavigator
import dev.pimentel.sekret.navigation.SekretNavigator
import org.koin.core.module.Module
import org.koin.dsl.module

object SekretModule {
    val default = module {
    }

    val navigator: (navController: NavController) -> Module = { navController ->
        module { single<SekretNavigator> { DefaultSekretNavigator(navController = navController) } }
    }
}
