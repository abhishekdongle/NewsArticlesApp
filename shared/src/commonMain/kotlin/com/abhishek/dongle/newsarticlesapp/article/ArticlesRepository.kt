package com.abhishek.dongle.newsarticlesapp.article

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles(): List<ArticleRaw> {
        val articlesDb = dataSource.getAllArticles()
        println("xxx: DB size = ${articlesDb.size}")
        if (articlesDb.isEmpty()) {
            val fetchedArticles = service.fetchArticles()
            dataSource.insertArticles(fetchedArticles)
            return fetchedArticles
        }
        return articlesDb
    }
}