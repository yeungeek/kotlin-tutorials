package com.yeungeek.kotlinprimer.chapter02

fun main() {
//    print("Hello World")
    lambdaA(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3)
}

val print = { name: String -> println(name) }
//22
val lambdaA = { a: Int, b: Int, c: Int, d: Int, e: Int, f: Int, g: Int, h: Int,
                i: Int, j: Int, k: Int, l: Int, m: Int, n: Int, o: Int, p: Int,
                q: Int, r: Int, s: Int, t: Int, u: Int, v: Int, w: Int, x: Int, y: Int ->
    println("Hello World")
}