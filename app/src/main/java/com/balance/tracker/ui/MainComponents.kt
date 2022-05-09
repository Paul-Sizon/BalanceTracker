package com.balance.tracker.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.balance.tracker.model.Balance
import com.balance.tracker.model.Currency
import com.balance.tracker.ui.theme.TrackerTheme

@Composable
fun Balance(balance: Balance) {
    Text(
        text = if (balance.positive) {
            balance.amount.toString() + " " + balance.currency
        } else {
            "- " + balance.amount.toString() + " " + balance.currency
        },
        modifier = Modifier.size(200.dp),
        color = if (balance.positive) {
            Color.Green
        } else {
            Color.Red
        }
    )
}

val mockBalance = Balance(20.0, Currency.USD, true)

@Composable
fun Screen() {
    Scaffold(
        content = { Balance(mockBalance) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*do something*/ }) {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrackerTheme {
        Screen()
    }
}