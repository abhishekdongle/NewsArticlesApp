package com.abhishek.dongle.newsarticlesapp.android.di

import com.abhishek.dongle.newsarticlesapp.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ArticlesViewModel(get()) }
}