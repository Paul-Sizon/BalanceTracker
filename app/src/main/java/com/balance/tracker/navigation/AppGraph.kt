package com.balance.tracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.balance.tracker.auth.AuthScreen
import com.balance.tracker.di.AppDependenciesStore
import com.balance.tracker.di.DaggerAuthComponent
import com.balance.tracker.ext.injectedViewModel
import dagger.Component

@Composable
fun AppGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.auth
    ) {
        composable(Destinations.auth) {
            val viewModel = injectedViewModel {
                DaggerAuthComponent.factory().create(AppDependenciesStore.appComponentApi).viewModel
            }
            AuthScreen(viewModel = viewModel)
        }
    }
}