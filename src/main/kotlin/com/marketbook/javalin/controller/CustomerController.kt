package com.marketbook.javalin.controller

import com.marketbook.javalin.model.CustomerModel
import com.marketbook.javalin.service.CustomerService

class CustomerController(
    private val customerService: CustomerService
) {
    fun getCustomers(): List<CustomerModel> {
        return customerService.getAllCustomers()
    }
}