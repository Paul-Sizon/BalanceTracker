package com.balance.tracker.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.balance.tracker.Greeting

@Composable
fun AuthScreen() {

}

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Greeting("Android auth")
    }
}