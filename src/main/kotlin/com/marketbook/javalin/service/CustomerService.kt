package com.marketbook.javalin.service

import com.marketbook.javalin.repository.CustomerRepository

class CustomerService(
    val customerRepository: CustomerRepository
) {
    fun getAllCustomers() {
        customerRepository.getAll()
    }
}