package com.example.domain.model.book

interface BookName {
    val value: String

    companion object {
        fun from(value: String): BookName = BookNameImpl(value)
    }
}

private data class BookNameImpl(override val value: String) : BookName