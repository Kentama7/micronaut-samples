package com.example.application.book

import com.example.domain.model.book.Book
import com.example.domain.model.book.BookFactory
import com.example.domain.model.book.BookId
import com.example.domain.model.book.BookName
import com.example.domain.model.book.BookRepository
import com.example.domain.service.BookService
import javax.inject.Singleton

@Singleton
class BookApplicationService(
    private val bookFactory: BookFactory,
    private val bookService: BookService,
    private val bookRepository: BookRepository
) {

    fun create(command: BookCreateCommand) {
        val book = bookFactory.create(BookName.from(command.bookName))
        if (bookService.exists(book)) {
            throw Exception("存在する")
        }
        bookRepository.save(book)
    }
}