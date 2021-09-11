package com.marketbook.javalin.factory

import com.marketbook.javalin.controller.BookController
import com.marketbook.javalin.controller.CustomerController
import com.marketbook.javalin.infra.ActivitiesRepositoryImpl
import com.marketbook.javalin.service.BookService
import com.marketbook.javalin.service.CustomerService

class ApplicationFactory {
    companion object {
        private val activitiesRepository = ActivitiesRepositoryImpl()
        private val customerService = CustomerService(activitiesRepository)
        val customerController = CustomerController(customerService)

        private val bookService = BookService(activitiesRepository)
        val bookController = BookController(bookService, customerService)
    }
}