package com.marketbook.javalin.service

import com.marketbook.javalin.infra.ActivitiesRepositoryImpl
import com.marketbook.javalin.model.CustomerModel

class CustomerService(
    val customerRepository: ActivitiesRepositoryImpl
) {
    fun getAllCustomers(name: String?): List<CustomerModel> {
        return customerRepository.fetchCustomers(name)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.fetchCustomer(id)
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.postCustomer(customer)
    }

    fun updateCustomer(customer: CustomerModel) {
        customerRepository.putCustomer(customer)
    }

    fun removeCustomer(id: Int) {
        customerRepository.deleteCustomer(id)
    }
}