package com.balance.tracker.model


data class Balance(
    val amount: Double,
    val currency: Currency,
    val positive: Boolean
)

enum class Currency{
    USD,
    GEL,
    BTC,
    RUB,
    AMD
}
