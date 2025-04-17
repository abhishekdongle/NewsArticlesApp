package com.abhishek.dongle.newsarticlesapp.android.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

open class BaseViewModel {
    private val job = Job()
    protected val scope = CoroutineScope(Dispatchers.Default + job)

    fun clear() {
        job.cancel()
    }
}