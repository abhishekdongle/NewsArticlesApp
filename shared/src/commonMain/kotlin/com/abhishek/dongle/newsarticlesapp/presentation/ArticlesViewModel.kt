package com.abhishek.dongle.newsarticlesapp.presentation

import com.abhishek.dongle.newsarticlesapp.BaseViewModel
import com.abhishek.dongle.newsarticlesapp.application.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val articlesUseCase: ArticlesUseCase
) : BaseViewModel() {
    private val _articleState = MutableStateFlow(ArticlesState())
    val articleState: StateFlow<ArticlesState> get() = _articleState

    init {
        getArticles()
    }

    fun getArticles(forceRefresh: Boolean = false) {
        scope.launch {
            _articleState.emit(ArticlesState(loading = true, articles = _articleState.value.articles))
            val fetchedArticles = articlesUseCase.getArticles(forceRefresh)
            _articleState.emit(ArticlesState(loading = false, articles = fetchedArticles))
        }
    }
}