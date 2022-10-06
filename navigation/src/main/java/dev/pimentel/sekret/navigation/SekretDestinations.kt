package dev.pimentel.sekret.navigation

sealed class SekretDestinations(internal val name: String) {
    object Login : SekretDestinations(name = "/login")
    object Passwords : SekretDestinations(name = "passwords")

    fun build(): String = BASE_URL + name

    private companion object {
        const val BASE_URL = "https://pimentel.dev"
    }
}
