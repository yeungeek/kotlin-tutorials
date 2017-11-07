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