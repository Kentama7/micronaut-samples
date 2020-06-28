package com.example.restservice

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import java.util.concurrent.atomic.AtomicLong

@Controller
class GreetingController {

    companion object {
        private const val template: String = "Hello, %s!"
        private val counter: AtomicLong = AtomicLong()
    }

    @Get("/greeting")
    fun greeting(@QueryValue(value = "name", defaultValue = "World") name: String): Greeting =
        Greeting(counter.incrementAndGet(), String.format(template, name))

}