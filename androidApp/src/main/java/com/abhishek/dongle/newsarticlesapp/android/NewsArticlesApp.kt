package com.abhishek.dongle.newsarticlesapp.android

import android.app.Application
import com.abhishek.dongle.newsarticlesapp.android.di.databaseModule
import com.abhishek.dongle.newsarticlesapp.android.di.viewModelModule
import com.abhishek.dongle.newsarticlesapp.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsArticlesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKotlin()
    }

    private fun initKotlin() {
        val modules = sharedKoinModule + viewModelModule + databaseModule
        startKoin {
            androidContext(this@NewsArticlesApp)
            modules(modules)
        }
    }
}