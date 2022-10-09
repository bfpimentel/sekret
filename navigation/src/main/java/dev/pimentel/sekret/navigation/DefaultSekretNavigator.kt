package dev.pimentel.sekret.navigation

import androidx.navigation.NavController

internal class DefaultSekretNavigator(private val navController: NavController) : SekretNavigator {

    override fun navigate(destination: SekretDestinations) {
        destination.navigate(navController = navController)
    }
}
