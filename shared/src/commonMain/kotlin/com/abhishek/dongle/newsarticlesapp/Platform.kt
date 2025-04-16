package com.abhishek.dongle.newsarticlesapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform