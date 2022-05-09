package com.balance.tracker.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.balance.tracker.ui.theme.TrackerTheme

@Composable
fun Balance(balance: Int) {
    Text(text = balance.toString(), Modifier.size(200.dp))
}

@Composable
fun Fab() {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*do something*/ }) {
            Icon(Icons.Filled.Add, contentDescription = "")
        }
    }) {
        Balance(20)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrackerTheme {
        Fab()
    }
}