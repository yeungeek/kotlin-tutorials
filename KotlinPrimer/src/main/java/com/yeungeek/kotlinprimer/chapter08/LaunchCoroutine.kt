package com.yeungeek.kotlinprimer.chapter08

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request

private val mOkHttpClient = OkHttpClient()
private val mRequest = Request.Builder().url("http://www.qq.com").get().build()

fun displayDashboard() = runBlocking {
    launch {
        val job = async {
            mOkHttpClient.newCall(mRequest).execute().body?.string()
        }

        println(job.await())
    }
}

fun main() {
    displayDashboard()
}