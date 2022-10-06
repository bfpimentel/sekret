package dev.pimentel.sekret.login

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import dev.pimentel.sekret.navigation.SekretDestinations

@Composable
fun LoginScreen(navController: NavController) {
    Button(onClick = { navController.navigate(SekretDestinations.Passwords.build()) }) {
        Text(text = "To Passwords")
    }
}
