package com.abhishek.dongle.newsarticlesapp.article

import com.abhishek.dongle.newsarticlesapp.BaseViewModel
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
            val fetchedArticles = articlesUseCase.getArticles(forceRefresh)
            _articleState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}