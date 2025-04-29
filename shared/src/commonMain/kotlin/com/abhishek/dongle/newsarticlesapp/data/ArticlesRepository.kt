package com.abhishek.dongle.newsarticlesapp.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles(forceRefresh: Boolean): List<ArticleRaw> {
        if (forceRefresh) {
            dataSource.clearArticles()
            return fetchArticles()
        }
        val cachedArticles = dataSource.getAllArticles()
        if (cachedArticles.isNotEmpty()) {
            return cachedArticles
        }
        return fetchArticles()
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        println("Fetched ${fetchedArticles.size} articles from API")
        return fetchedArticles
    }
}