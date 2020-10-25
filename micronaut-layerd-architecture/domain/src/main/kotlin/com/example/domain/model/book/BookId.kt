package com.example.domain.model.book

interface BookId {
    val value: Long

    companion object {
        fun from(value: Long): BookId = BookIdImpl(value)
    }
}

private data class BookIdImpl(override val value: Long) : BookId