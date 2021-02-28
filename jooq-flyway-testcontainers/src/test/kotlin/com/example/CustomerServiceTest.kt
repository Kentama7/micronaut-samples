package com.example

import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class CustomerServiceTest {

    @Inject
    lateinit var customerService: CustomerService

    @Test
    @DisplayName("countのテスト")
    fun count() {
        assertEquals(3, customerService.count())
    }

    @Test
    @DisplayName("insertのテスト")
    fun add() {
        assertEquals(1, customerService.add())
    }

    @Test
    @DisplayName("deleteのテスト")
    fun delete() {
        assertEquals(1, customerService.delete())
        assertEquals(2, customerService.count())
    }
}