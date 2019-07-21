package com.yeungeek.kotlinprimer

import com.yeungeek.kotlinprimer.Test.format

fun main(args: Array<String>) {
    test("")
}

fun test(str: String) {
    val f = format(str)
//    println(f.length)

    val f1: String? = format(str)
    println(f1?.length)
}