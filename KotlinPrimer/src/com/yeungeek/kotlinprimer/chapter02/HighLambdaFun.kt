package com.yeungeek.kotlinprimer.chapter02

fun main() {
//    onlyIf(true) { println("Hello World") }
    val runnable = Runnable {
        println("runnable::run")
    }

    var function: () -> Unit
    function = runnable::run

    onlyIf(true, function)
}

inline fun onlyIf(isDebug: Boolean, block: () -> Unit) {
    if (isDebug) block()
}