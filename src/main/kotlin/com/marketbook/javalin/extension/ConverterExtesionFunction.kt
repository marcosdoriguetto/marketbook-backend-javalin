package com.marketbook.javalin.extension

import com.marketbook.javalin.controller.request.PostBookRequest
import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutBookRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.enums.BookStatus
import com.marketbook.javalin.model.BookModel
import com.marketbook.javalin.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel =
    CustomerModel(name = this.name, email = this.email)

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel =
    CustomerModel(id = id, name = this.name, email = this.email)

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousBook: BookModel): BookModel {
    return BookModel(
        id = previousBook.id,
        name = this.name ?: previousBook.name,
        price = this.price ?: previousBook.price,
        status = previousBook.status,
        customer = previousBook.customer
    )
}