package com.abhishek.dongle.newsarticlesapp.di

import com.abhishek.dongle.newsarticlesapp.presentation.ArticlesViewModel
import org.koin.core.context.startKoin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

fun initKoin() {
    val modules = sharedKoinModule + databaseModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}