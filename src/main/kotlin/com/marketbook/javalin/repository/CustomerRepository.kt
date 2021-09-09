package com.marketbook.javalin.repository

import com.marketbook.javalin.model.CustomerModel

interface CustomerRepository {
    fun getAll(): List<CustomerModel>
}
