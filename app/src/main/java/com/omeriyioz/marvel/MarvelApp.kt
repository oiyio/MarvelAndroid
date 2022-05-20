package com.omeriyioz.marvel

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MarvelApp
    }
}
