package com.abhishek.dongle.newsarticlesapp.di

import com.abhishek.dongle.newsarticlesapp.article.ArticlesService
import com.abhishek.dongle.newsarticlesapp.article.ArticlesUseCase
import com.abhishek.dongle.newsarticlesapp.article.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}