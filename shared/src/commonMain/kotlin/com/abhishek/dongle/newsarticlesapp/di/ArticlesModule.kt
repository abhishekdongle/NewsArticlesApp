package com.abhishek.dongle.newsarticlesapp.di

import com.abhishek.dongle.newsarticlesapp.article.ArticlesDataSource
import com.abhishek.dongle.newsarticlesapp.article.ArticlesRepository
import com.abhishek.dongle.newsarticlesapp.article.ArticlesService
import com.abhishek.dongle.newsarticlesapp.article.ArticlesUseCase
import com.abhishek.dongle.newsarticlesapp.article.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}