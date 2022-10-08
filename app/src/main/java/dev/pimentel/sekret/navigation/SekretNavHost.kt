package dev.pimentel.sekret.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.pimentel.sekret.login.LoginScreen
import dev.pimentel.sekret.passwords.PasswordsScreen

@Composable
fun SekretNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SekretDestinations.Login.build()
    ) {
        composable(SekretDestinations.Login.build()) {
            LoginScreen()
        }

        composable(SekretDestinations.Passwords.build()) {
            PasswordsScreen()
        }
    }
}
