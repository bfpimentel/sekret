package dev.pimentel.sekret.login

import android.R.drawable.ic_delete
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.pimentel.sekret.di.sekretKoin
import dev.pimentel.sekret.di.viewModel

@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = sekretKoin().viewModel()
    val state by viewModel.state.collectAsState()

    LoginScreenView(
        state = state,
        navigateToPasswords = viewModel::navigateToPasswords,
        setPassword = viewModel::setPassword
    )
}

@Composable
private fun LoginScreenView(
    state: LoginViewState,
    navigateToPasswords: () -> Unit = {},
    setPassword: (String) -> Unit = {},
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

            OutlinedTextField(
                modifier = Modifier.constrainAs(password) {
                    centerTo(parent)
                    top.linkTo(logo.bottom, margin = 16.dp)
                    bottom.linkTo(button.top)
                },
                value = state.password,
                placeholder = { Text(text = "Password") },
                onValueChange = setPassword
            )

            OutlinedButton(
                modifier = Modifier.constrainAs(button) {
                    centerTo(parent)
                    top.linkTo(password.bottom, margin = 16.dp)
                },
                enabled = state.isLoginEnabled,
                onClick = navigateToPasswords
            ) {
                Text(text = "Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreenView(
        state = LoginViewState()
    )
}
