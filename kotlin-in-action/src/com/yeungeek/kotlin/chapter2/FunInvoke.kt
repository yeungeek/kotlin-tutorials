package com.yeungeek.kotlin.chapter2

fun main() {
    val set = setOf(1, 7, 12)
    val list = listOf(1, 3, 4)
    val map = mapOf(1 to "one", 3 to "three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println("last:  " + set.last())
    println("list max: " + list.max())
    println("list to String: " + joinToString(list, ",", "(", ")"))
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuffer(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}