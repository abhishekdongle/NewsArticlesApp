package com.abhishek.dongle.newsarticlesapp.android.article

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticlesViewModel {
    private val _articleState = MutableStateFlow(ArticleState())
    val articleState: StateFlow<ArticleState> get() = _articleState
}