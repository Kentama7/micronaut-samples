package com.example.infra.book

import com.example.domain.model.book.Book
import com.example.domain.model.book.BookId
import com.example.domain.model.book.BookName
import com.example.domain.model.book.BookRepository
import javax.inject.Singleton

@Singleton
class BookRepositoryImpl: BookRepository {
    override fun save(book: Book) {

    }

    override fun find(id: BookId): Book? {
        TODO("Not yet implemented")
    }

    override fun find(name: BookName): Book? {
        return null
    }
}