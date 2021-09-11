package com.marketbook.javalin.service

import com.marketbook.javalin.enums.BookStatus
import com.marketbook.javalin.infra.ActivitiesRepositoryImpl
import com.marketbook.javalin.model.BookModel

class BookService(
    val bookRepository: ActivitiesRepositoryImpl
) {
    fun getBooks(status: String?): List<BookModel> {
        return bookRepository.fetchBooks(status)
    }

    fun getBook(id: Int): BookModel {
        return bookRepository.fetchBook(id)
    }

    fun getBooksStatus(status: String): List<BookModel> {
        return bookRepository.fetchBooksStatus(status)
    }

    fun createBook(book: BookModel) {
        bookRepository.postBook(book)
    }

    fun updateBook(book: BookModel) {
        bookRepository.putBook(book)
    }

    fun deleteBook(id: Int) {
        bookRepository.deleteBook(id)
    }
}