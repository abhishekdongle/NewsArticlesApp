package com.abhishek.dongle.newsarticlesapp.di

import com.abhishek.dongle.newsarticlesapp.article.ArticlesViewModel
import org.koin.core.context.startKoin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

fun initKoin() {
    val modules = sharedKoinModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}