package com.yeungeek.kotlinprimer.chapter07

import com.sun.istack.internal.NotNull
import com.sun.istack.internal.Nullable

object JavaNullTest {
    @JvmStatic
    fun main(args: Array<String>) {
        testNotNull(null)
        testNull("Test")
    }

    fun testNotNull(@NotNull value: String?) {
        println(value)
    }

    fun testNull(@Nullable value: String?) {
        println(value)
    }
}