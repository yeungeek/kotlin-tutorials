package com.yeungeek.kotlin.begin

/**
 * main
 */
fun main(args: Array<String>) {
    val a: Int = 3  // immediate assignment
    val b = 4
    val c: Int

    var x = 5

    println("return int:" + sum(a, b))
    c = 5

    println("return null int:" + nullSum(c, 6))
    printSum(x, 6)

    stringTemplate()

    println("max of 3,5:" + maxof(3, 5))
    println("sMaxOf of 3,5:" + sMaxOf(3, 5))

    useNull("3", "4")
    useNull("3", "b")
    useNull("a", "b")

    println("str auto: " + autoCast("12345"))
    println(autoCast(123))

    forLoop()
    whileLoop()

    println(whenExpre(1))
    println(whenExpre(23))
    println(whenExpre(34L))
    println(whenExpre("str"))

    useRange(3)
    useRange(12)

    useForRange()
    println()

    useCollection()
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun nullSum(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun stringTemplate() {
    var a = 1
    val s1 = "a is $a"

    a = 2
    // "${s1.replace("is", "was")}, but now is $a"
    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s2)
}

fun maxof(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun sMaxOf(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun useNull(str1: String, str2: String) {
    val x = parseInt(str1)
    val y = parseInt(str2)

    if (x != null && y != null) {
        println("x*y=" + x * y)
    } else {
        println("not int")
    }
}

fun autoCast(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }

    return null
}

fun forLoop() {
    var list = listOf("a", "b", "c")
    for (item in list) {
        print(item + " ")
    }
    println()
}

fun whileLoop() {
    val list = listOf("e", "f", "g")
    var index = 0
    while (index < list.size) {
        println("item at $index is ${list[index]}")
        index++
    }
}

fun whenExpre(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }


fun useRange(x: Int) {
    var y = 9
    if (x in 1..y + 1) {
        println("fits")
    } else {
        println("not fits")
    }
}

fun useForRange() {
    for (x in 1..9 step 2) {
        print(x)
    }

    println()

    for (x in 9 downTo 1 step 3) {
        print(x)
    }
}

fun useCollection() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}