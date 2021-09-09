package com.marketbook.javalin.service

import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.infra.ActivitiesRepositoryImpl
import com.marketbook.javalin.model.CustomerModel
import com.marketbook.javalin.repository.CustomerRepository

class CustomerService(
    val customerRepository: ActivitiesRepositoryImpl
) {
    fun getAllCustomers(): List<CustomerModel> {
        return customerRepository.fetchCustomers()
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.fetchCustomer(id)
    }

    fun createCustomer(customer: PostCustomerRequest) {
        customerRepository.postCustomer(customer)
    }

    fun updateCustomer(id: Int, customer: PutCustomerRequest) {
        customerRepository.putCustomer(id, customer)
    }

    fun removeCustomer(id: Int) {
        customerRepository.deleteCustomer(id)
    }
}