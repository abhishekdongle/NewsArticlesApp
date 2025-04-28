package com.abhishek.dongle.newsarticlesapp.article

import com.abhishek.dongle.newsarticlesapp.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel : BaseViewModel() {
    private val _articleState = MutableStateFlow(ArticlesState())
    val articleState: StateFlow<ArticlesState> get() = _articleState

    private var articlesUseCase: ArticlesUseCase

    init {
        val httpClient = getHttpClient()
        val articlesService = ArticlesService(httpClient)
        articlesUseCase = ArticlesUseCase(articlesService)
        getArticles()
    }

    private fun getHttpClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = articlesUseCase.getArticles()
            _articleState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}