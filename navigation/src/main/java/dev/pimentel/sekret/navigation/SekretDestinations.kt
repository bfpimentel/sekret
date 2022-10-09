package dev.pimentel.sekret.navigation

import androidx.navigation.NavController

sealed class SekretDestinations(internal val name: String) {

    fun route(): String = BASE_URL + name

    internal abstract fun navigate(navController: NavController)

    object Login : SekretDestinations(name = "/login") {
        override fun navigate(navController: NavController) {
            navController.navigate(route()) {
                popUpTo(NO_DESTINATION) {
                    inclusive = true
                }
            }
        }
    }

    object Passwords : SekretDestinations(name = "/passwords") {
        override fun navigate(navController: NavController) {
            navController.navigate(route()) {
                popUpTo(NO_DESTINATION) {
                    inclusive = true
                }
            }
        }
    }

    private companion object {
        const val BASE_URL = "https://pimentel.dev"
        const val NO_DESTINATION = 0
    }
}
