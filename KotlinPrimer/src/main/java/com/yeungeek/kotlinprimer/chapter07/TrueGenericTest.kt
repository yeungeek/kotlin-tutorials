package com.yeungeek.kotlinprimer.chapter07

import com.google.gson.Gson


fun main() {
    val b = View<Presenter>().presenter

    val a = View.invoke<Presenter>().presenter
    println(b)
    println(a)
}

inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}

class View<T>(val clazz: Class<T>) {
    val presenter by lazy { clazz.newInstance() }

    companion object {
        inline operator fun <reified T> invoke() = View(T::class.java)
    }
}

class Presenter {
    override fun toString(): String {
        return "presenter: " + hashCode()
    }
}