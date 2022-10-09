package dev.pimentel.sekret.navigation

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class DefaultSekretNavigator(private val navController: NavController) : SekretNavigator {

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun navigate(destination: SekretDestinations) {
        scope.launch { destination.navigate(navController = navController) }
    }
}
