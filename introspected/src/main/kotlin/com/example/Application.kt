package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.beans.BeanIntrospection
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.example")
        .start()
}

@Introspected
data class Foo(
    val name: String,
    val age: Int
)

@Controller
class FooController {
    @Get
    fun get(): HttpResponse<Foo> =
        BeanIntrospection
            .getIntrospection(Foo::class.java)
            .instantiate("a", 1)
            .let { HttpResponse.ok(it) }
}