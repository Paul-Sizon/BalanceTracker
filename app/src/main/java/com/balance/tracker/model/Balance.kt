package com.balance.tracker.model


data class Balance(
    val amount: Double,
    val currency: Currency
) {
    fun getBalance() = amount.toString() + " " + currency.symbol
}

enum class Currency(val symbol: String) {
    USD("$"),
    GEL("₾"),
    BTC("Ƀ"),
    EUR("€"),
    RUB("₽"),
    AMD("֏")
}
