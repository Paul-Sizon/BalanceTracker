package com.balance.tracker.auth

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.balance.tracker.ui.GoogleButton
import com.balance.tracker.ui.theme.TrackerTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreenContent(googleIntent: Intent, handleAuth: (ActivityResult) -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            ,
        bottomBar = {
            GoogleButton(
                modifier = Modifier.padding(24.dp),
                intent = googleIntent,
                handleAuth = handleAuth
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "WELCOME!!!!!")
        }
    }
}

@Composable
fun AuthScreen(viewModel: AuthViewModel, navigateNext: () -> Unit) {
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