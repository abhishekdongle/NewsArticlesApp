package com.abhishek.dongle.newsarticlesapp.di

import com.abhishek.dongle.newsarticlesapp.data.ArticlesDataSource
import com.abhishek.dongle.newsarticlesapp.data.ArticlesRepository
import com.abhishek.dongle.newsarticlesapp.data.ArticlesService
import com.abhishek.dongle.newsarticlesapp.application.ArticlesUseCase
import com.abhishek.dongle.newsarticlesapp.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}