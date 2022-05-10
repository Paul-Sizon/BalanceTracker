package com.balance.tracker.di

import com.balance.tracker.auth.AuthViewModel
import com.balance.tracker.auth.api.AuthRepository
import com.balance.tracker.auth.api.FirebaseAuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Binds
import dagger.Component
import dagger.Module

@Component(
    modules = [AuthModule::class],
    dependencies = [AppComponentApi::class]
)
interface AuthComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponentApi: AppComponentApi
        ): AuthComponent
    }

    val viewModel: AuthViewModel
}

@Module
interface AuthModule {

    @Binds
    fun bindAuthRepo(impl: FirebaseAuthRepositoryImpl): AuthRepository
}