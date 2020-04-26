package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //1.
//    launch {
//        println("main run block: thread ${Thread.currentThread().name}")
//    }
//
//    launch(Dispatchers.Unconfined) {
//        println("Unconfined: thread ${Thread.currentThread().name}")
//    }
//
//    launch(Dispatchers.Default) {
//        println("Default: thread ${Thread.currentThread().name}")
//    }
//
//    launch(newSingleThreadContext("CustomThread")) {
//        println("newSingleThreadContext: thread ${Thread.currentThread().name}")
//    }

    //2.
//    launch(Dispatchers.Unconfined) {
//        println("Unconfined before: thread ${Thread.currentThread().name}")
//        delay(500)
//        println("Unconfined after: thread ${Thread.currentThread().name}")
//    }
//
//    launch {
//        println("main block before: thread ${Thread.currentThread().name}")
//        delay(500)
//        println("main block after: thread ${Thread.currentThread().name}")
//    }

    //3.
//    val a = async {
//        log("a")
//        10
//    }
//
//    val b = async {
//        log("b")
//        20
//    }
//
//    log("a+b=${a.await() + b.await()}")

    //5.
    println("job context: ${coroutineContext[Job]}")
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")