package com.marketbook.javalin.factory

import com.marketbook.javalin.controller.CustomerController
import com.marketbook.javalin.infra.ActivitiesRepositoryImpl
import com.marketbook.javalin.service.CustomerService

class ApplicationFactory {
    companion object {
        private val customerRepository = ActivitiesRepositoryImpl()
        private val customerService = CustomerService(customerRepository)
        val customerController = CustomerController(customerService)
    }
}