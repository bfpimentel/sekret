package dev.pimentel.sekret.login

import androidx.lifecycle.ViewModel
import dev.pimentel.sekret.navigation.SekretDestinations
import dev.pimentel.sekret.navigation.SekretNavigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class LoginViewModel(
    private val sekretNavigator: SekretNavigator
) : ViewModel() {

    private val mutableState: MutableStateFlow<LoginViewState> = MutableStateFlow(LoginViewState())
    val state: StateFlow<LoginViewState> = mutableState

    fun setPassword(password: String) {
        mutableState.update { currentState ->
            currentState.copy(
                password = password,
                isLoginEnabled = password.isNotEmpty()
            )
        }
    }

    fun navigateToPasswords() {
        sekretNavigator.navigate(SekretDestinations.Passwords)
    }
}
