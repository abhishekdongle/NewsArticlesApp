package com.abhishek.dongle.newsarticlesapp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.abhishek.dongle.newsarticlesapp.db.DatabaseDriverFactory
import com.abhishek.dongle.newsarticlesapp.db.NewsArticlesAppDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<NewsArticlesAppDB> { NewsArticlesAppDB(get()) }
}