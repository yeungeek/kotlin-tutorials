package com.yeungeek.kotlinapp.eventbus

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

var map = mutableMapOf<String, Channel<Any>>()

inline fun <reified T> T.post() {
    if (!map.containsKey(T::class.java.name)) {
        map.put(T::class.java.name, Channel())


    }
}