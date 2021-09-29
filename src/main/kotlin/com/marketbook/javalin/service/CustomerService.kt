package com.marketbook.javalin.service

import com.marketbook.javalin.infra.ActivitiesRepositoryImpl
import com.marketbook.javalin.model.CustomerModel
import com.marketbook.javalin.model.PaginationModel

class CustomerService(
    val customerRepository: ActivitiesRepositoryImpl
) {
    fun getAllCustomers(name: String?, page: PaginationModel?): List<CustomerModel> {
        return customerRepository.fetchCustomers(name, page)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.fetchCustomer(id)
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.postCustomer(customer)
    }

    fun updateCustomer(customer: CustomerModel) {
        if(!customerRepository.fetchCustomer(customer.id!!)) {
            throw Exception()
        }
        customerRepository.putCustomer(customer)
    }

    fun removeCustomer(id: Int) {
        if(!customerRepository.fetchCustomer(id)) {
            throw Exception()
        }
        customerRepository.deleteBooksByCustomer(id)
    }
}