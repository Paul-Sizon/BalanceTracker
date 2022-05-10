package com.balance.tracker.ui

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.balance.tracker.R

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    intent: Intent,
    handleAuth: (ActivityResult) -> Unit
) {
    val openGoogleAuthActivity = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = handleAuth
    )
    OutlinedButton(
        modifier = modifier,
        onClick = { openGoogleAuthActivity.launch(intent) },
        border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp),
        shape = CutCornerShape(15)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                text = "Continue with Google".uppercase(),
                textAlign = TextAlign.Center,
            )
        }
    }
}