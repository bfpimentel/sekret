package dev.pimentel.sekret.login

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.pimentel.sekret.di.sekretKoinGet
import dev.pimentel.sekret.navigation.SekretDestinations
import dev.pimentel.sekret.navigation.SekretNavigator

@Composable
fun LoginScreen(sekretNavigator: SekretNavigator = sekretKoinGet()) {
    Button(onClick = { sekretNavigator.navigate(SekretDestinations.Passwords) }) {
        Text(text = "To Passwords")
    }
}
