package com.balance.tracker.model

import com.balance.tracker.ui.theme.TrackerColors

data class Purchase(
    val amount: Double,
    val currency: Currency,
    //todo? Name as class
    val name: String,
    val item: String
) {
    fun getColor() = if (amount >= 0) {
        TrackerColors.darkGreen
    } else {
        TrackerColors.red
    }
}
