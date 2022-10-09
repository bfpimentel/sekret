package dev.pimentel.sekret.login.di

import dev.pimentel.sekret.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LoginModule {
    val module = module {
        viewModel { LoginViewModel(sekretNavigator = get()) }
    }
}
