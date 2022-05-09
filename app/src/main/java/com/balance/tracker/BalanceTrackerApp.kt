package com.balance.tracker

import android.app.Application
import com.google.firebase.FirebaseApp
import timber.log.Timber

class BalanceTrackerApp : Application() {
    override fun onCreate() {
        Timber.plant(Timber.DebugTree())
        Timber.d("onApplicationCreate")
        FirebaseApp.initializeApp(this)
        super.onCreate()
    }
}