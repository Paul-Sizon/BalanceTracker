package com.balance.tracker.auth

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.balance.tracker.R
import com.balance.tracker.ui.GoogleButton
import com.balance.tracker.ui.theme.TrackerTheme
import com.balance.tracker.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AuthScreenContent(
    googleIntent: Intent,
    handleAuth: (ActivityResult) -> Unit
) {
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            GoogleButton(
                modifier = Modifier.padding(24.dp),
                intent = googleIntent,
                handleAuth = handleAuth
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
//                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(innerPadding)
                .consumedWindowInsets(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "WELCOME", style = Typography.h4)
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun AuthScreen(viewModel: AuthViewModel, navigateNext: () -> Unit) {
    AuthScreenContent(
//        paddingValues = paddingValues,
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