package com.sohainfotech.findallstay.container

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.sohainfotech.findallstay.di.appModule
import com.sohainfotech.findallstay.di.repositoryModule
import com.sohainfotech.findallstay.di.viewModelModule
import okhttp3.internal.Internal.instance
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //to access global context using---> BaseApplication.instance
        instance = applicationContext

        startKoin {
            // modules(appModule) //pass modules
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: Context
    }
}