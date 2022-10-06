package dev.pimentel.sekret

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.pimentel.sekret.di.SekretKoinComponent
import dev.pimentel.sekret.navigation.SekretNavHost
import dev.pimentel.sekret.ui.theme.SekretTheme

class MainActivity : ComponentActivity(), SekretKoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SekretTheme {
                SekretNavHost()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SekretTheme {
        Greeting("Android")
    }
}
