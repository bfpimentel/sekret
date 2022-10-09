package dev.pimentel.sekret.login

internal data class LoginViewState(
    val password: String = "",
    val isLoginEnabled: Boolean = false,
)
