package com.balance.tracker.auth

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.balance.tracker.ui.GoogleButton
import com.balance.tracker.ui.theme.TrackerTheme


@Composable
fun AuthScreenContent(googleIntent: Intent, handleAuth: (ActivityResult) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.padding(start = 18.dp, end = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            GoogleButton(intent = googleIntent, handleAuth = handleAuth)
        }
    }
}

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    AuthScreenContent(
        googleIntent = viewModel.googleSignInClient.signInIntent,
        handleAuth = viewModel::handleGoogleAuthResult
    )
}

@Preview
@Composable
fun AuthScreenPreview() {
    TrackerTheme {
        AuthScreenContent(googleIntent = Intent(), handleAuth = {})
    }
}