package com.example

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.jooq.DSLContext
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class JooqFlywayTestcontainersTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

}

@MicronautTest
class Hoge(
    private val dslContext: DSLContext
) {

    @Test
    fun a() {
        println(dslContext.select().from("public.customer").where("id = 1").fetchOne())
        println(dslContext.select().from("public.customer").where("id = 2").fetchOne())
        println(dslContext.select().from("public.customer").where("id = 3").fetchOne())
        println(dslContext.select().from("public.customer").where("id = 4").fetchOne())
    }
}
