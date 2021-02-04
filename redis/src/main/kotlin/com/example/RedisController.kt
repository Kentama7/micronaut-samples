package com.example

import io.lettuce.core.api.StatefulRedisConnection
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put

@Controller
class RedisController(
    private val connection: StatefulRedisConnection<String, String>
) {
    @Get("ping")
    fun ping(): String {
        val commands = connection.sync()
        return commands.ping()
    }

    @Put
    fun put(@Body id: String): String {
        val commands = connection.sync()
        return commands.set("id", id)
    }

    @Get
    fun id(): String {
        val commands = connection.sync()
        return commands.get("id")
    }
}