package com.marketbook.javalin.httpServer

import com.marketbook.javalin.controller.CustomerController
import com.marketbook.javalin.controller.request.PostBookRequest
import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutBookRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.factory.ApplicationFactory
import com.marketbook.javalin.model.CustomerModel
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

fun start() {
    val app = Javalin.create{
        it.enableCorsForAllOrigins()
    }.start(8080)

    app.routes {
        path("customers") {
            get {
                val name = it.queryParam("name")
                it.json(ApplicationFactory.customerController.getCustomers(name))
            }
            post {
                val customer = it.body<PostCustomerRequest>()
                it.json(ApplicationFactory.customerController.createCustomer(customer))
            }
            path(":id") {
                get {
                    it.json(ApplicationFactory.customerController.getCustomer(it.pathParam("id").toInt()))
                }
                put {
                    val customer = it.body<PutCustomerRequest>()
                    it.json(ApplicationFactory.customerController.updateCustomer(it.pathParam("id").toInt(), customer))
                }
                delete {
                    it.json(ApplicationFactory.customerController.removeCustomer(it.pathParam("id").toInt()))
                }
            }
        }
        path("books") {
            get {
                val status = it.queryParam("name")
                it.json(ApplicationFactory.bookController.getBooks(status))
            }
            get("/customer/:id") {
                it.json(ApplicationFactory.bookController.getBooksByCustomer(it.pathParam("id").toInt()))
            }
            post {
                val book = it.body<PostBookRequest>()
                it.json(ApplicationFactory.bookController.createBook(book))
            }
            path(":id") {
                get {
                    it.json(ApplicationFactory.bookController.getBook(it.pathParam("id").toInt()))
                }
                put {
                    val book = it.body<PutBookRequest>()
                    it.json(ApplicationFactory.bookController.updateBook(it.pathParam("id").toInt(), book))
                }
                delete {
                    it.json(ApplicationFactory.bookController.removeBook(it.pathParam("id").toInt()))
                }
            }

        }
    }
}
