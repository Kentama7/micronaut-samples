package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class HelloControllerTest(
//    @field:Client("/")
//    private val client: RxHttpClient
) {

    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals("Hello World", body)
    }

    @Test
    fun testPost() {
        val request: HttpRequest<Any> = HttpRequest.POST("/hello", Greeting("neko"))
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals("{\"name\":\"neko\"}", body)
    }
}