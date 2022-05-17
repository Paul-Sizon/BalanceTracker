package com.balance.tracker.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.balance.tracker.auth.AuthScreen
import com.balance.tracker.di.AppDependenciesStore
import com.balance.tracker.di.DaggerAuthComponent
import com.balance.tracker.ext.injectedViewModel
import com.balance.tracker.ui.MainScreen
import com.balance.tracker.ui.theme.TrackerTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AppGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(containerColor = MaterialTheme.colorScheme.background) { padding ->

        Row(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(
                    WindowInsets.safeDrawing
//                        .only(
//                        WindowInsetsSides.Horizontal
//                    )
                )
        ) {
            NavHost(
                modifier = modifier
                    .padding(padding)
                    .consumedWindowInsets(padding),
                navController = navController,
                startDestination = Destinations.auth
            ) {
                composable(Destinations.auth) {
                    val viewModel = injectedViewModel {
                        DaggerAuthComponent.factory()
                            .create(AppDependenciesStore.appComponentApi).viewModel
                    }
                    AuthScreen(
                        viewModel = viewModel,
//                            padding
                    ) { navController.navigate(Destinations.main) }
                }
                composable(Destinations.main) {
                    MainScreen()
                }
            }
        }
    }
}