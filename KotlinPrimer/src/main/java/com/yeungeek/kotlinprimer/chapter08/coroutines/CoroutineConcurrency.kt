package com.yeungeek.kotlinprimer.chapter08.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.w3c.dom.css.Counter
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

//@Volatile
var count = 0


//val count = AtomicInteger()
val countContext = newSingleThreadContext("count")
val mutex = Mutex()

fun main() = runBlocking<Unit> {
//    withContext(Dispatchers.Default) {
//        massiveRun {
//            withContext(countContext) {
//                count++
//            }
//        }
//    }

//    withContext(countContext) {
//        massiveRun {
//            count++
//        }
//    }

    //03
//    withContext(Dispatchers.Default) {
//        massiveRun {
//            mutex.withLock {
//                count++
//            }
//        }
//    }
//
//    println("count: $count")

    //04.
    val counter = countActor()
    withContext(Dispatchers.Default) {
        massiveRun {
            counter.send(IncCounter)
        }
    }

    val response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))
    println("Counter= ${response.await()}")
    counter.close()
}


sealed class CounterMsg
object IncCounter : CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

fun CoroutineScope.countActor() = actor<CounterMsg> {
    var counter = 0
    for (msg in channel) {
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}

suspend fun massiveRun(action: suspend () -> Unit) {
    val i = 100
    val j = 1000

    val time = measureTimeMillis {
        coroutineScope {
            repeat(i) {
                launch {
                    repeat(j) {
                        action()
                    }
                }
            }
        }
    }

    println("Completed ${i * j} actions in $time ms")
}