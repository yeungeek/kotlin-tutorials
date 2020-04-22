package com.yeungeek.kotlinprimer.chapter02

import java.io.File

fun main() {
    var file = File("KotlinPrimer.iml")
    println(file.readText())
}