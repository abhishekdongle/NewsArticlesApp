package com.abhishek.dongle.newsarticlesapp.application

import com.abhishek.dongle.newsarticlesapp.data.ArticleRaw
import com.abhishek.dongle.newsarticlesapp.data.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val repository: ArticlesRepository) {

    suspend fun getArticles(forceRefresh: Boolean): List<Article> {
        val articlesRaw = repository.getArticles(forceRefresh)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>) = articlesRaw.map { raw ->
        Article(
            title = raw.title,
            desc = raw.desc ?: "Upcoming details",
            date = getDaysAgo(raw.date),
            imageUrl = raw.imageUrl
                ?: "https://techcrunch.com/wp-content/uploads/2024/05/Minecraft-keyart.jpg?resize=1200,720"
        )
    }

    private fun getDaysAgo(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        return when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
    }
}