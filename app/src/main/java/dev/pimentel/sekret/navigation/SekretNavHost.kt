package dev.pimentel.sekret.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.pimentel.sekret.login.LoginScreen
import dev.pimentel.sekret.passwords.PasswordsScreen

@Composable
fun SekretNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SekretDestinations.Login.build()
    ) {
        composable(SekretDestinations.Login.build()) {
            LoginScreen(navController = navController)
        }

        composable(SekretDestinations.Passwords.build()) {
            PasswordsScreen(navController = navController)
        }
    }
}
