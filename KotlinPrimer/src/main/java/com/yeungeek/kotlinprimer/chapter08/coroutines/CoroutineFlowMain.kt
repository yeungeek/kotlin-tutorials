package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //1.
//    testSeq().forEach { value ->
//        println(value)
//    }

    //2.

}

fun testSeq(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100)
        yield(i)
    }
}