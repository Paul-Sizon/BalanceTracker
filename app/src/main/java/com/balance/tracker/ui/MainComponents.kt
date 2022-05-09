package com.balance.tracker.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.balance.tracker.model.Balance
import com.balance.tracker.model.Currency
import com.balance.tracker.ui.theme.TrackerColors
import com.balance.tracker.ui.theme.TrackerTheme
import com.balance.tracker.ui.theme.fonts

@Composable
fun Balance(balance: Balance) {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 230.dp),

        ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(20.dp)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                fontSize = 60.sp,
                text = balance.amount.toString() + " " + balance.currency.symbol,
                color = if (balance.amount >= 0) {
                    TrackerColors.darkGreen
                } else {
                    TrackerColors.red
                },
                fontFamily = fonts
            )
        }

    }

}

val mockBalance = Balance(2000.0, Currency.USD)

@Composable
fun Screen() {
    Scaffold(
        content = {
            Balance(mockBalance)
        },
        backgroundColor = TrackerColors.grey,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*do something*/ }) {
                Icon(Icons.Default.Add, contentDescription = "")
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