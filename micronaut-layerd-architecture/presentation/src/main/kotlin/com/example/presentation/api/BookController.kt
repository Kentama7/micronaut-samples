package com.example.presentation.api

import com.example.application.book.BookApplicationService
import com.example.application.book.BookCreateCommand
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("books")
class BookController(
    private val bookApplicationService: BookApplicationService
) {
    @Get
    fun create() {
        val command = BookCreateCommand("なまえ")
        bookApplicationService.create(command)
    }
}