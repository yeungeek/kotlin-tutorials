package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //1.
//    testSeq().forEach { value ->
//        println(value)
//    }

    //2.
//    launch {
//        for (i in 1..3) {
//            println("main block $i")
//            delay(100)
//        }
//    }
//
//    testFlow().collect { value -> println(value) }

    //3.
    (1..5).asFlow()
        .filter {
            println("filter $it")
            it % 2 == 0
        }.map {
            println("Map $it")
            "string $it"
        }.collect {
            println("Collect $it")
        }
}

fun testSeq(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100)
        yield(i)
    }
}

fun testFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}