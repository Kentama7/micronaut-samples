package com.example.domain.model.book

interface Book {
    val id: BookId
    val name: BookName

    companion object {
        fun from(id: BookId, name: BookName): Book = BookImpl(id, name)
    }
}

private data class BookImpl(override val id: BookId, override val name: BookName) : Book