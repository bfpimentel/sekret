package dev.pimentel.sekret.navigation

import androidx.navigation.NavController

class DefaultSekretNavigator(private val navController: NavController) : SekretNavigator {

    override fun navigate(destination: SekretDestinations) {
        navController.navigate(destination.build())
    }
}
