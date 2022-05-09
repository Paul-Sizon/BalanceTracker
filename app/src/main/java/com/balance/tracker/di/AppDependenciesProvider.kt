package com.balance.tracker.di

import kotlin.properties.Delegates

interface AppDependenciesProvider {
    val appComponentApi: AppComponentApi

    companion object : AppDependenciesProvider by AppDependenciesStore
}

object AppDependenciesStore : AppDependenciesProvider {
    override var appComponentApi: AppComponentApi by Delegates.notNull()
}