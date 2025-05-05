package com.abhishek.dongle.newsarticlesapp.di

import app.cash.sqldelight.db.SqlDriver
import com.abhishek.dongle.newsarticlesapp.db.DatabaseDriverFactory
import com.abhishek.dongle.newsarticlesapp.db.NewsArticlesAppDB
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<NewsArticlesAppDB> { NewsArticlesAppDB(get()) }
}