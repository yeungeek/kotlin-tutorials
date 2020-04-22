package com.yeungeek.kotlinprimer.chapter02

/**
 * fun 函数
 */
fun main() {
    echo()
    echo("Echo")
    function()
}

fun function() {
    val hello = "Hello World"
    fun inFun(count: Int = 10) {
        println(hello)
        if (count > 0) {
            inFun(count - 1)
        }
    }

    inFun()
}

//fun echo(name:String){
//    println("$name")
//}

fun echo(name: String = "Hello World") {
    println("$name")
}