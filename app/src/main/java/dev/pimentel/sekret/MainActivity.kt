package dev.pimentel.sekret

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dev.pimentel.sekret.di.SekretKoin
import dev.pimentel.sekret.di.SekretKoinComponent
import dev.pimentel.sekret.di.SekretModule
import dev.pimentel.sekret.di.loadModule
import dev.pimentel.sekret.navigation.SekretNavHost
import dev.pimentel.sekret.ui.theme.SekretTheme

class MainActivity : ComponentActivity(), SekretKoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            SekretKoin.getKoin().loadModule(SekretModule.navigator(navController))

            SekretTheme {
                SekretNavHost(navController = navController)
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
