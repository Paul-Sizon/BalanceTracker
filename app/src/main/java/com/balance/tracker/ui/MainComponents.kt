package com.balance.tracker.ui

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.balance.tracker.ui.theme.TrackerTheme

@Composable
fun Balance(balance: Int) {
    Text(text = balance.toString())
}

@Composable
fun Fab() {
    FloatingActionButton(onClick = { /*do something*/ }) {
        Icon(Icons.Filled.Favorite, contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrackerTheme {
        Balance(20)
        Fab()
    }
}