package com.marketbook.javalin.controller

import com.marketbook.javalin.controller.request.PostBookRequest
import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.extension.toBookModel
import com.marketbook.javalin.extension.toCustomerModel
import com.marketbook.javalin.model.BookModel
import com.marketbook.javalin.model.CustomerModel
import com.marketbook.javalin.model.PaginationModel
import com.marketbook.javalin.service.CustomerService

class CustomerController(
    private val customerService: CustomerService
) {
    fun getCustomers(name: String?, page: PaginationModel?): List<CustomerModel> {
        return customerService.getAllCustomers(name, page)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerService.getCustomer(id)
    }

    fun createCustomer(customer: PostCustomerRequest) {
        customerService.createCustomer(customer.toCustomerModel())
    }

    fun updateCustomer(id: Int, customer: PutCustomerRequest) {
        customerService.updateCustomer(customer.toCustomerModel(id))
    }

    fun removeCustomer(id: Int) {
        customerService.removeCustomer(id)
    }
}