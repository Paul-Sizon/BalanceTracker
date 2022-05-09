package com.balance.tracker

import android.app.Application
import com.balance.tracker.di.AppComponent
import com.balance.tracker.di.DaggerAppComponent
import com.google.firebase.FirebaseApp
import timber.log.Timber

class BalanceTrackerApp : Application() {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        Timber.plant(Timber.DebugTree())
        Timber.d("onApplicationCreate")
        FirebaseApp.initializeApp(this)
        super.onCreate()

        appComponent = DaggerAppComponent.builder().context(this).build()
    }
}