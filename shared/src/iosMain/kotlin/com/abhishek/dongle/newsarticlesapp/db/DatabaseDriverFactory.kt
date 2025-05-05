package com.abhishek.dongle.newsarticlesapp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory() {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = NewsArticlesAppDB.Schema,
            name = "NewsArticlesAppDB.db"
        )
}