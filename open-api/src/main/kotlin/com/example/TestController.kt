package com.example

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/test")
class TestController {
    @Get
    fun get(): Person = Person("太郎", "浦島", 10)

    @Post
    fun post(@Body person: Person): Person = person
}

data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int
)