package dev.pimentel.sekret.passwords

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.pimentel.sekret.di.sekretKoinGet
import dev.pimentel.sekret.navigation.SekretDestinations
import dev.pimentel.sekret.navigation.SekretNavigator

@Composable
fun PasswordsScreen(sekretNavigator: SekretNavigator = sekretKoinGet()) {
    Button(onClick = { sekretNavigator.navigate(SekretDestinations.Login) }) {
        Text(text = "To Login")
    }
}
