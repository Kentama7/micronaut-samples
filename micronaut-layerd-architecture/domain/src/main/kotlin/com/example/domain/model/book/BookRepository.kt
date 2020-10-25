package com.example.domain.model.book

interface BookRepository {
    fun save(book: Book)
    fun find(id: BookId): Book?
    fun find(name: BookName): Book?
}