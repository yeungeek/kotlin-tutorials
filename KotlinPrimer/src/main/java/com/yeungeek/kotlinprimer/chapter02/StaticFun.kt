package com.yeungeek.kotlinprimer.chapter02

fun main() {
    Dog().printName(Dog())
}

open class Animal

class Dog : Animal()

fun Animal.name() = "Animal"

fun Dog.name() = "Dog"

fun Animal.printName(animal: Animal) {
    println(animal.name())
}