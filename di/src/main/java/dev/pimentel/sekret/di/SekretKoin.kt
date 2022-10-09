package dev.pimentel.sekret.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope

object SekretKoin : KoinComponent {
    private var koinApplication: KoinApplication? = null

    fun initialize(koinApplication: KoinApplication) {
        this.koinApplication = koinApplication
    }

    override fun getKoin(): Koin = koinApplication?.koin
        ?: throw IllegalStateException("Koin has not been initialized.")
}

@Composable
fun sekretKoin(): Koin = remember { SekretKoin.getKoin() }

@OptIn(KoinInternalApi::class)
@Composable
inline fun <reified T : ViewModel> Koin.viewModel(
    qualifier: Qualifier? = null,
    owner: ViewModelStoreOwner? = null,
    scope: Scope = this.scopeRegistry.rootScope,
    noinline parameters: ParametersDefinition? = null,
): T = org.koin.androidx.compose.getViewModel(qualifier, owner, scope, parameters)




