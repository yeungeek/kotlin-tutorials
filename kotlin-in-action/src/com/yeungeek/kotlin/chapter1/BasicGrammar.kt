package com.yeungeek.kotlin.chapter1

import java.util.*

fun main() {
    println("Hello Kotlin")
    println("Max: " + max(3, 10))
    val_test()
    testClass()

    println(createRandomRectangle().isSquure)
    println(getColor(Color.RED))
    testFor()
}

fun fromKotlin(): String {
    return "From Kotlin"
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max_1(a: Int, b: Int) = if (a > b) a else b

fun val_test() {
    val h: Int
    h = 3

    var w: String
    w = "Kotlin"

    println("Hello ${if (h > 2) w else "test"}!")
}

fun testClass() {
    val person = Person("yeungeek")
    println(person.name)
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun getColor(color: Color) = when (color) {
    Color.BLUE -> "BLUE"
    Color.GREEN -> "GREEN"
    Color.ORANGE -> "ORANGE"
    Color.RED -> "RED"
}

fun testFor() {
    val binaryRes = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryRes[c] = binary
    }

    for ((letter, binary) in binaryRes) {
        println("$letter = $binary")
    }
}

/**
 * CLASS
 */
class Person(val name: String)

class Rectangle(val height: Int, val width: Int) {
    val isSquure: Boolean
        get() = height == width
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 265, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b
}
