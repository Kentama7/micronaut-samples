package com.example.domain.model.book

import javax.inject.Singleton

interface BookFactory {
    fun create(name: BookName): Book
}

@Singleton
class BookFactoryImpl : BookFactory {
    override fun create(name: BookName): Book = Book.from(BookId.from(-1), name)
}