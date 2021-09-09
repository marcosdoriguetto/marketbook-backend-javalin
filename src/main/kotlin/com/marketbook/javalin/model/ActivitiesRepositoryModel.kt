package com.marketbook.javalin.model

import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest

interface ActivitiesRepositoryModel {
    fun fetchCustomers(): List<CustomerModel>
    fun fetchCustomer(id: Int): CustomerModel
    fun getLastId(): CustomerModel
    fun postCustomer(customer: PostCustomerRequest)
    fun putCustomer(id: Int, customer: PutCustomerRequest)
    fun deleteCustomer(id: Int)
}