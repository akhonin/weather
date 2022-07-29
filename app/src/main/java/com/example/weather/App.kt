package com.example.weather

import android.accounts.Account
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instans = this
    }

    companion object {
        var account: Account? = null
        var instans: App? = null
    }
}