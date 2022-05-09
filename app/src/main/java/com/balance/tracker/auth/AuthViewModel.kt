package com.balance.tracker.auth

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
class AuthViewModel @Inject constructor(
    private val context: Context
) : ViewModel() {

    init {
        val ass = context.assets
    }

}