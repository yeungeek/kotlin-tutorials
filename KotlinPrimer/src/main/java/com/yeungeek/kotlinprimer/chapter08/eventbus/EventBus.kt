package com.yeungeek.kotlinprimer.chapter08.eventbus

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

var map = mutableMapOf<String, Channel<Any>>()
inline fun <reified T> T.post() {
    println("##### post: " + T::class.java.name)

    if (!map.containsKey(T::class.java.name)) {
        map.put(T::class.java.name, Channel())
    }

    //@sse https://code.luasoftware.com/tutorials/android/migrating-to-kotlin-13-coroutines/
    GlobalScope.launch(Dispatchers.Default) {
        println("##### post launch: " + map[T::class.java.name])
        map[T::class.java.name]?.send(this@post as Any)
    }
}

inline fun <T, reified R> T.onEvent(noinline action: suspend (R) -> Unit) {
    println("##### onEvent: " + R::class.java.name)
    if (!map.containsKey(R::class.java.name)) {
        map.put(R::class.java.name, Channel())
    }

    GlobalScope.launch(Dispatchers.Default) {
        val receive = map[R::class.java.name]?.receive()
        println("##### onEvent receive: " + receive)

        GlobalScope.launch(Dispatchers.Main) {
            println("##### onEvent launch: " + R::class.java.name)
            action.invoke(receive as R)
        }
    }
}

//inline fun <T, reified R> T.onEvent(noinline action: suspend (R) -> Unit) {
//    if (!map.containsKey(R::class.java.name)) {
//        map.put(R::class.java.name, Channel())
//    }
//
//    GlobalScope.launch(Dispatchers.Default) {
//        val receive = map[R::class.java.name]?.receive()
//        GlobalScope.launch(Dispatchers.Main) {
//            action.invoke(receive as R)
//        }
//    }
//}