package com.yeungeek.kotlinprimer.chapter07

import java.util.*

class Person(var year: Int) {
    val age: Int
        get() {
            return Calendar.getInstance().get(Calendar.YEAR) - year
        }

    fun yearPlus() {
        year--
    }
}