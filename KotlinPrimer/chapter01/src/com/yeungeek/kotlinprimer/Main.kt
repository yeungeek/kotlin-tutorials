package com.yeungeek.kotlinprimer

import com.yeungeek.kotlinprimer.Test.format

fun main(args: Array<String>) {
    val age = 20
    var name = "Hello Kotlin"
    var nameS: String? = "S Hello"
//    name = nameS
    nameS = name
    echo(nameS)

    Single.message("Hello Kotlin Single")
    test("")
}

fun test(str: String) {
    val f = format(str)
//    println(f.length)

    val f1: String? = format(str)
    println(f1?.length)
}