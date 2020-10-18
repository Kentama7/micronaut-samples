package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.example")
        .start()
}

@Controller
class HogeController {
    @Get
    fun index(): String {
        return "hello"
    }
}