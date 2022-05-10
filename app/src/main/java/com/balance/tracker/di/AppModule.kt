package com.balance.tracker.di

import android.app.Application
import android.content.Context
import com.balance.tracker.auth.AuthViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(modules = [AppModule::class])
interface AppComponent : AppComponentApi {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}

interface AppComponentApi {
    fun applicationContext(): Context
}

@Module
interface AppModule {

    @Binds
    abstract fun bindContext(app: Application): Context
}



