package dev.pimentel.sekret.passwords

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import dev.pimentel.sekret.navigation.SekretDestinations

@Composable
fun PasswordsScreen(navController: NavController) {
    Button(onClick = { navController.navigate(SekretDestinations.Login.build()) }) {
        Text(text = "To Login")
    }
}
