package com.yeungeek.kotlinprimer.chapter01

var age: Int = 18
const val name = "yeungeek"

var name1: String = "name1"
var name2: String? = "name2"

var nameLength: String? = null

fun main() {
    println("main")
    println("age: $age, name: $name")
//    println("age: %d, name: %d", age, name)

//    name1 = name2
    name2 = name1
    println("name2 value: $name2")

    //length
    println(nameLength?.length)

    printlnLength(null)

    echo("test echo")

    Single.sayHello("Kotlin Single")

    //class
    println(JavaMain::class.java)
    println(Single::class)

    //interface
    var j = JavaImpl()
    j.println(123)

    //reflect
    val clazz = JavaImpl::class.java
    clazz.getMethod("println", `Integer`::class.java).invoke(j, 123)

    testFormat("testFormat", j)
}

fun testFormat(str: String, imp: JavaImpl) {
    val fmt1 = imp.format(str)
    val fmt2: String = imp.format(str)
    val fmt3: String? = imp.format(str)

    println(fmt1::class)
    println(fmt2::class.java)
    println(fmt3!!::class)
}

fun printlnLength(name: String?) {
    println(name?.length)
}

