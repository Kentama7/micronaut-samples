package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

@Controller("hello")
class HelloController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun index() = "Hello World"

    @Post
    fun post(@Body greeting: Greeting): HttpResponse<Greeting> = HttpResponse.created(greeting)
}

data class Greeting(
    val name: String
)