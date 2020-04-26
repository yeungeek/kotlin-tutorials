package com.yeungeek.kotlinprimer.chapter08

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import com.yeungeek.kotlinprimer.chapter08.eventbus.onEvent
import com.yeungeek.kotlinprimer.chapter08.eventbus.post
import kotlinx.coroutines.delay

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

fun main() = runBlocking {
//    displayDashboard()
    onEvent { str: String ->
        println(str)
    }

    delay(1000)
    test1()
}

fun test1() {
    "test1".post()
}