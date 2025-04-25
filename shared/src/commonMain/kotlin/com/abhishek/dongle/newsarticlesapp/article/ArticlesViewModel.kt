package com.abhishek.dongle.newsarticlesapp.article

import com.abhishek.dongle.newsarticlesapp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {
    private val _articleState = MutableStateFlow(ArticlesState())
    val articleState: StateFlow<ArticlesState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            _articleState.emit(ArticlesState(error = "Something went wrong."))
            delay(1000)

            val fetchedArticles = fetchArticles()
            _articleState.emit(ArticlesState(articles = fetchedArticles))
        }

    }

    private fun fetchArticles() = mockArticle

    private val mockArticle = listOf(
        Article(
            title = "Bitcoin Prediction - Crypto Market for BINANCE:BTCUSDT.P by UA_CAPITAL",
            desc = "Bitcoin has broken the weekly structure to the downside, and we've been bearish since then. However, the monthly chart still looks bullish, and I expect the price to return to the monthly demand zone and get a reaction from there. I believe the crypto market could turn bullish again by the end of ...",
            date = "2025-04-10",
            imageUrl = "https://s3.tradingview.com/g/GkAsIJWO_big.png"
        ),
        Article(
            title = "How to Recover Stolen Cryptocurrency with Proven Methods",
            desc = "Stolen cryptocurrency can be recovered. The need to recover stolen crypto has never been more urgent. Crypto thieves have already stolen approximately $730 million through different scams in the first two months of 2025 alone. These thefts account for one-third of all crypto heists from last ...",
            date = "2025-04-10",
            imageUrl = "https://assets.infosecurity-magazine.com/webpage/tw/605e115e-d012-4227-aa8b-df499239a604.jpg"
        ),
        Article(
            title = "Warren Buffett Holds Record $334 Billion in Cash -- And Why He's Still Snubbing Bitcoin",
            desc = "Investigations suggest Berkshire's anti-Bitcoin stance may stem from business interests tied to natural gas, not just ideology. Warren Buffett, Chairman and CEO of Berkshire Hathaway, has once again drawn global attention. His firm now holds a record-breaking $334 billion cash balance -- the ...",
            date = "2025-04-10",
            imageUrl = "https://beincrypto.com/wp-content/uploads/2023/10/BIC_Warren_Buffet-covers_positive.png.webp"
        ),
        Article(
            title = "BIT Mining Announces March 2025 Production and Operations Updates",
            desc = "AKRON, Ohio, April 10, 2025 /PRNewswire/ -- BIT Mining Limited (NYSE: BTCM) (\"BIT Mining\" or the \"Company\"), a leading technology-driven cryptocurrency mining company, today released its monthly mining production and operational updates for March 2025. BIT Mining continues to expand its ...",
            date = "2025-04-10",
            imageUrl = "https://greenstocknews.com/images/ogimage.jpg"
        ),
        Article(
            title = "Sandow Lakes' natural gas power plant location was its selling point. Until it wasn't.",
            desc = "Many cheered when Sandow Lakes Energy first announced plans to build a huge new natural gas power plant in a region within the Texas Triangle still reeling from the loss of a major industrial complex. Gov. Greg Abbott and Texas lawmakers touted the new power plant's potential to supply more ...",
            date = "2025-04-10",
            imageUrl = "https://s.yimg.com/cv/apiv2/social/images/yahoo_default_logo-1200x1200.png"
        )
    )
}