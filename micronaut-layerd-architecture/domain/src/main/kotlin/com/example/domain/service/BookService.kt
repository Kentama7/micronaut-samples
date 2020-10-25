package com.example.domain.service

import com.example.domain.model.book.Book
import com.example.domain.model.book.BookRepository
import javax.inject.Singleton

@Singleton
class BookService(
    private val bookRepository: BookRepository
) {
    fun exists(book: Book): Boolean = bookRepository.find(book.name) != null
}
