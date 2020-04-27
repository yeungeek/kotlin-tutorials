package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.*
import java.lang.AssertionError

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception -> println("Catch $exception") }

    val job = GlobalScope.launch(handler) {
        throw AssertionError()
    }

    val de = GlobalScope.async(handler) {
        throw ArithmeticException()
    }

    println("${de.await()}")

    joinAll(job, de)
}