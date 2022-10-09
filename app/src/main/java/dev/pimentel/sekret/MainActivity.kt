package dev.pimentel.sekret

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.pimentel.sekret.di.SekretKoin
import dev.pimentel.sekret.login.di.LoginModule
import dev.pimentel.sekret.navigation.SekretNavHost
import dev.pimentel.sekret.navigation.di.NavigationModule
import dev.pimentel.sekret.ui.theme.SekretTheme
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            initializeKoin(navController = navController)

            SekretTheme {
                SekretNavHost(navController = navController)
            }
        }
    }
}

private fun initializeKoin(navController: NavController) {
    val koinInstance = startKoin {
        modules(
            NavigationModule.module(navController),
            LoginModule.module,
        )
    }

    SekretKoin.initialize(koinInstance)
}
