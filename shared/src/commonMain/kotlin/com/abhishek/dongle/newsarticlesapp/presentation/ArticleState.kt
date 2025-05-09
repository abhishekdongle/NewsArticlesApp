package com.abhishek.dongle.newsarticlesapp.presentation

import com.abhishek.dongle.newsarticlesapp.application.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)