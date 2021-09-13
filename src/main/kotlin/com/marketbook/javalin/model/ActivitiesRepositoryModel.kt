package com.marketbook.javalin.model

import com.marketbook.javalin.enums.BookStatus

interface ActivitiesRepositoryModel {
    //Customers
    fun fetchCustomers(name: String?): List<CustomerModel>
    fun fetchCustomer(id: Int): CustomerModel
    fun getLastCustomerId(): CustomerModel
    fun postCustomer(customer: CustomerModel)
    fun putCustomer(customer: CustomerModel)
    fun deleteCustomer(id: Int)
    //Books
    fun fetchBooks(status: String?): List<BookModel>
    fun fetchBook(id: Int): BookModel
    fun fetchBooksCustomer(id: Int): List<BookModel>
    fun fetchBooksStatus(status: String): List<BookModel>
    fun getLastBookId(): BookModel
    fun postBook(book: BookModel)
    fun putBook(book: BookModel)
    fun deleteBooksByCustomer(id: Int)
    fun deleteBook(id: Int)
}