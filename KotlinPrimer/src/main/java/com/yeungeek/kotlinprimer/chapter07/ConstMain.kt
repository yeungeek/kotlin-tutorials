package com.yeungeek.kotlinprimer.chapter07

/**
 * val,var,const diff
 */
fun main() {
    var test = Test()
    println(test.str1)

    test.str = "Add"
    println(test.str)

    //const test
    val person = Person(18)
    println(person.age)
    person.yearPlus()
    println(person.age)

    //Test1
    println(Test1.s)
}

class Test {
    var str: String? = null
        get() {
            return field + " Hello"
        }
        set(value) {
            field = value + " Set"
        }

    val str1: String? = null
        get() {
            return field + " val Hello"
        }
    //set(value) {}
}

class Test1 {
    companion object {
        const val s = 2
    }

    var num: Int = 0
        set(value) {
            field = value + 1
        }
}