package com.balance.tracker

import android.app.Application
import com.balance.tracker.di.AppComponent
import com.balance.tracker.di.AppDependenciesStore
import com.balance.tracker.di.DaggerAppComponent
import com.google.firebase.FirebaseApp
import timber.log.Timber

class BalanceTrackerApp : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        Timber.plant(Timber.DebugTree())
        Timber.d("onApplicationCreate")
        FirebaseApp.initializeApp(this)
        super.onCreate()

        AppDependenciesStore.appComponentApi = appComponent
    }
}