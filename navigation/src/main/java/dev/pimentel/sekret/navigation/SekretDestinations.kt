package dev.pimentel.sekret.navigation

import androidx.navigation.NavController

sealed class SekretDestinations(internal val name: String) {
    object Login : SekretDestinations(name = "/login") {
        fun NavController.test() {
        }
    }
    object Passwords : SekretDestinations(name = "passwords")

    fun build(): String = BASE_URL + name

    private companion object {
        const val BASE_URL = "https://pimentel.dev"
    }
}
