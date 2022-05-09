package com.balance.tracker.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}

@Module
interface AppModule {

}

@Component
interface AuthComponent {

}

@Module
interface AuthModule {

}

