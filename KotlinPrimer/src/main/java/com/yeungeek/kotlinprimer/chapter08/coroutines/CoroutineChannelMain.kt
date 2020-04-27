package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //1.
    val channel = Channel<Int>()
    launch {
        for (i in 1..5) channel.send(i * i)
    }

    repeat(5) { println(channel.receive()) }

    println("Done!")
}