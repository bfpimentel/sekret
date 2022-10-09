package dev.pimentel.sekret.login

import android.R.drawable.ic_delete
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.pimentel.sekret.di.sekretKoinGet
import dev.pimentel.sekret.navigation.SekretDestinations
import dev.pimentel.sekret.navigation.SekretNavigator

@Composable
fun LoginScreen(sekretNavigator: SekretNavigator = sekretKoinGet()) {
    LoginScreenContent(
        navigateToLogin = { sekretNavigator.navigate(SekretDestinations.Passwords) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginScreenContent(
    navigateToLogin: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.align(Alignment.Center)) {
            val (logo, password, button) = createRefs()

            Image(
                modifier = Modifier
                    .size(48.dp)
                    .constrainAs(logo) {
                        centerTo(parent)
                        bottom.linkTo(password.top)
                    },
                painter = painterResource(id = ic_delete), contentDescription = "logo"
            )

            TextField(
                modifier = Modifier.constrainAs(password) {
                    centerTo(parent)
                    top.linkTo(logo.bottom, margin = 16.dp)
                    bottom.linkTo(button.top)
                },
                value = "",
                placeholder = { Text(text = "Password") },
                onValueChange = { }
            )

            Button(
                modifier = Modifier.constrainAs(button) {
                    centerTo(parent)
                    top.linkTo(password.bottom, margin = 16.dp)
                }, onClick = navigateToLogin
            ) {
                Text(text = "Login")
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreenContent()
}
