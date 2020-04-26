package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.Exception
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    //1.
//    val time = measureTimeMillis {
//        val calOne = caclOneAsync()
//        val calTow = caclTwoAsync()
//        runBlocking {
//            println("result: ${calOne.await() + calTow.await()}")
//        }
//    }
//
//    println("time cost: $time")

    val time = measureTimeMillis {
        println("result: ${calcSum()}")
    }

    println("time cost: $time")

//    try {
//        failedSum()
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }

}

fun caclOneAsync() = GlobalScope.async {
    calcOneMethod()
}

fun caclTwoAsync() = GlobalScope.async {
    calcTwoMethod()
}

suspend fun calcOneMethod(): Int {
    delay(1000)
    return 10
}

suspend fun calcTwoMethod(): Int {
    delay(2000)
    return 20
}

suspend fun calcSum(): Int = coroutineScope {
    val calcOne = async { calcOneMethod() }
    val calcTwo = async { calcTwoMethod() }

    calcOne.await() + calcTwo.await()
}

suspend fun failedSum(): Int = coroutineScope {
    val calcOne = async {
        try {
            delay(Long.MAX_VALUE)
            42
        } finally {
            println("First child was cancelled")
        }
    }

    val calcTow = async {
        println("Second child throws an exception")
        throw ArithmeticException()
    }

    calcOne.await()
}