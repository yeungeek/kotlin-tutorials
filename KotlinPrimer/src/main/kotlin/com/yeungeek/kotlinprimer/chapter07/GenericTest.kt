package com.yeungeek.kotlinprimer.chapter07

fun main() {
    val test = GTest<B>()
    test.add(B())
}

class GTest<T> where T : Callback, T : Runnable {
    fun add(t: T) {
        t.callback()
        t.run()
    }
}

open class A : Callback {
    override fun callback() {
        println("Callback call")
    }
}

class B : Runnable, A() {
    override fun run() {
        println("Runnable Run")
    }
}

interface Callback {
    fun callback()
}