package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
//    GlobalScope.launch {
//        delay(1000)
//        println("World!")
//    }
//
//    println("Hello")
    //01
//    Thread.sleep(2000)

    //02
//    runBlocking {
//        //no blocking
//        delay(2000)
//    }

    //03. main
//    delay(2000)


//    //04.
//    val job = GlobalScope.launch {
//        delay(1000)
//        println("World!")
//    }
//
//    println("Hello")
//    job.join()  // wait until child coroutine completes

    //05
//    launch {
//        delay(1000)
//        println("World!")
//    }
//
//    println("Hello")

    //06.
//    launch {
//        delay(200)
//        println("Task from runBlocking")
//    }
//
//    // Creates a coroutine scope
//    coroutineScope {
//        launch {
//            delay(500)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope")
//    }
//
//    println("Coroutine scope is over")

    //07.
//    launch { doWork() }
//    println("Hello")

    //08.
//    repeat(100_100) { i ->
//        launch {
//            delay(1000)
//            println("repeat: $i")
//        }
//    }

    //09.
//    GlobalScope.launch {
//        repeat(1000) { i ->
//            println("repeat $i")
//            delay(500)
//        }
//    }
//
//    delay(1300)

    /*** cancel and timeout ***/
    //10.
//    val job = launch {
//        repeat(20) { i ->
//            println("job: I'm sleeping $i ...")
//            delay(500)
//        }
//    }
//
//    delay(1300)
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin()
//    println("main: Now I can quit.")

    //11.
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
////        while (i < 5) {
//        while (isActive) {
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("job: I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//
//    delay(1300)
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin()
//    println("main: Now I can quit.")

    //12.
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("job: I'm sleeping $i ...")
//                delay(500)
//            }
//        } finally {
//            println("job: I'm running finally")
//        }
//    }
//
//    delay(1300)
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin()
//    println("main: Now I can quit.")

    //13.
//    val result = withTimeoutOrNull(1300) {
//        repeat(100) { i ->
//            println("I'm sleeping $i ...")
//            delay(500)
//        }
//        "Done!"
//    }
//
//    println("Result is $result")

    //14.
//    val time = measureTimeMillis {
//        val timeOne = caclOne()
//        val timeTwo = caclTwo()
//        println("result: ${timeOne + timeTwo}")
//    }
//
//    println("time cost: $time")

    //15. async
//    val time = measureTimeMillis {
//        val timeOne = async { caclOne() }
//        val timeTwo = async { caclTwo() }
//        println("result: ${timeOne.await() + timeTwo.await()}")
//    }
//
//    println("time cost: $time")

    //16. async lazy
    val time = measureTimeMillis {
        val timeOne = async(start = CoroutineStart.LAZY) { caclOne() }
        val timeTwo = async(start = CoroutineStart.LAZY) { caclTwo() }
        timeOne.start()
        timeTwo.start()
        println("result: ${timeOne.await() + timeTwo.await()}")
    }

    println("time cost: $time")
}

suspend fun caclOne(): Int {
    delay(1000)
    return 10
}

suspend fun caclTwo(): Int {
    delay(2000)
    return 30
}

suspend fun cancelWork() {

}

suspend fun doWork() {
    delay(1000)
    println("World!")
}