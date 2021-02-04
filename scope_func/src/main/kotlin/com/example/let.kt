package com.example

fun main() {
    println("foo".let { it.toUpperCase() })
    println(1.let { it + 1 })
}