package com.balance.tracker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.balance.tracker.model.Balance
import com.balance.tracker.model.Currency
import com.balance.tracker.model.Purchase
import com.balance.tracker.ui.theme.Teal200
import com.balance.tracker.ui.theme.TrackerColors
import com.balance.tracker.ui.theme.TrackerTheme
import com.balance.tracker.ui.theme.fonts

val mockBalance = Balance(2000.0, Currency.USD)
val mockBalance2 = Balance(0.0, Currency.USD)
val mockBalance3 = Balance(-27.0, Currency.USD)
val mockBalance4 = Balance(800.0, Currency.USD)
val mockBalance5 = Balance(-34.0, Currency.USD)

val mockPurchase = Purchase(2000.0, Currency.GEL, "Paul", "PS4")
val mockPurchase2 = Purchase(0.0, Currency.USD, "Danya", "Hinkali")
val mockPurchase3 = Purchase(-27.0, Currency.USD, "Paul", "PS4")
val mockPurchase4 = Purchase(800.0, Currency.RUB, "Kira", "Tea")
val mockPurchase5 = Purchase(-34.0, Currency.USD, "Paul", "PS4")
val mockListOfPurchases =
    listOf<Purchase>(mockPurchase, mockPurchase2, mockPurchase3, mockPurchase4, mockPurchase5)

@Composable
fun Screen() {
    Scaffold(
        content = {
            Column() {
                PricesColumn(list = mockListOfPurchases)
                Balance(mockBalance)
            }
        },
        bottomBar = {
            BottomAppBar(cutoutShape = RoundedCornerShape(50), backgroundColor = Teal200) {
            }
        },
        backgroundColor = TrackerColors.grey,
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.size(80.dp),
                onClick = { /*do something*/ }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "",
                    modifier = Modifier.size(45.dp),
                    tint = TrackerColors.grey
                )
            }
        })
}

@Composable
fun PricesColumn(list: List<Purchase>) {
    LazyColumn(modifier = Modifier.fillMaxHeight(0.67f)) {
        itemsIndexed(list) { index, _ ->
            Element(purchase = list[index])
        }
    }
}

@Composable
fun Balance(balance: Balance) {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),

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

@Composable
fun Element(purchase: Purchase) {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        backgroundColor = if (purchase.amount >= 0) {
            TrackerColors.darkGreen
        } else {
            TrackerColors.red
        },
    ) {
        Row(modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = purchase.amount.toString() + purchase.currency.symbol,
                fontSize = 30.sp,
                color = Color.Black,
                fontFamily = fonts
            )
            Text(
                text = purchase.name,
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = fonts
            )
            Text(
                text = purchase.item,
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = fonts
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrackerTheme {
        Screen()
    }
}