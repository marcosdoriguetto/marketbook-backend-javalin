package com.marketbook.javalin.controller

import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.model.CustomerModel
import com.marketbook.javalin.service.CustomerService

class CustomerController(
    private val customerService: CustomerService
) {
    fun getCustomers(): List<CustomerModel> {
        return customerService.getAllCustomers()
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerService.getCustomer(id)
    }

    fun createCustomer(customer: PostCustomerRequest) {
        customerService.createCustomer(customer)
    }

    fun updateCustomer(id: Int, customer: PutCustomerRequest) {
        customerService.updateCustomer(id, customer)
    }

    fun removeCustomer(id: Int) {
        customerService.removeCustomer(id)
    }
}