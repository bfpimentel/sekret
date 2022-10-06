package dev.pimentel.sekret.di

import androidx.navigation.NavController
import dev.pimentel.sekret.navigation.DefaultSekretNavigator
import dev.pimentel.sekret.navigation.SekretNavigator
import org.koin.core.module.Module
import org.koin.dsl.module

object SekretModule {
    val module = module {
        single<SekretNavigator> { (navController: NavController) ->
            DefaultSekretNavigator(navController = navController)
        }
    }

    val navigator: (navController: NavController) -> Module = { navController ->
        module { single<SekretNavigator> { DefaultSekretNavigator(navController = navController) } }
    }
}
