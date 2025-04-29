package com.abhishek.dongle.newsarticlesapp.article

import com.abhishek.dongle.newsarticlesapp.db.NewsArticlesAppDB

class ArticlesDataSource(private val database: NewsArticlesAppDB) {

    suspend fun getAllArticles(): List<ArticleRaw> {
        return database.newsArticlesAppDBQueries.selectAllArticles(::mapToArticleRaw)
            .executeAsList()
    }

    fun insertArticles(articles: List<ArticleRaw>) {
        database.newsArticlesAppDBQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    private fun insertArticle(article: ArticleRaw) {
        database.newsArticlesAppDBQueries.insertArticle(
            article.title,
            article.desc,
            article.date,
            article.imageUrl
        )
    }

    fun clearArticles() = database.newsArticlesAppDBQueries.removeAllArticles()

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleRaw =
        ArticleRaw(
            title = title,
            desc = desc,
            date = date,
            imageUrl = url
        )
}