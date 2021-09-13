package com.marketbook.javalin.controller

import com.marketbook.javalin.controller.request.PostBookRequest
import com.marketbook.javalin.controller.request.PutBookRequest
import com.marketbook.javalin.enums.BookStatus
import com.marketbook.javalin.extension.toBookModel
import com.marketbook.javalin.model.BookModel
import com.marketbook.javalin.service.BookService
import com.marketbook.javalin.service.CustomerService

class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    fun getBooks(status: String?): List<BookModel> {
        return bookService.getBooks(status)
    }

    fun getBook(id: Int): BookModel {
        return bookService.getBook(id)
    }

    fun getBooksStatus(status: String): List<BookModel> {
        return bookService.getBooksStatus(status)
    }

    fun getBooksByCustomer(id: Int): List<BookModel> {
        return bookService.getBooksByCustomer(id)
    }

    fun createBook(book: PostBookRequest) {
        val customer = customerService.getCustomer(book.customerId)
        bookService.createBook(book.toBookModel(customer))
    }

    fun updateBook(id: Int, book: PutBookRequest) {
        val bookSaved = bookService.getBook(id)
        bookService.updateBook(book.toBookModel(bookSaved))
    }

    fun removeBook(id: Int) {
        bookService.deleteBook(id)
    }
}