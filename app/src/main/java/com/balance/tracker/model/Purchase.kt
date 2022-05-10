package com.balance.tracker.model

data class Purchase(
    val amount: Double,
    val currency: Currency,
    //todo? Name as class
    val name: String,
    val item: String
)
