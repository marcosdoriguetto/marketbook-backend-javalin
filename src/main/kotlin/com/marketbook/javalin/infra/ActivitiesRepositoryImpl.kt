package com.marketbook.javalin.infra

import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.infra.connection.DatabaseHelper
import com.marketbook.javalin.infra.mapper.CustomerMapper
import com.marketbook.javalin.model.ActivitiesRepositoryModel
import com.marketbook.javalin.model.CustomerModel

class ActivitiesRepositoryImpl: ActivitiesRepositoryModel {
    override fun fetchCustomers(): List<CustomerModel> {
        return DatabaseHelper.runCommand {
            it.select("SELECT * FROM customer").map(CustomerMapper()).list()
        }
    }

    override fun fetchCustomer(id: Int): CustomerModel {
        return DatabaseHelper.runCommand {
            it.select("SELECT * FROM customer WHERE id IN ($id)").map(CustomerMapper()).findOnly()
        }
    }

    override fun getLastId(): CustomerModel {
        return DatabaseHelper.runCommand {
            it.select("SELECT * FROM customer").map(CustomerMapper()).last()
        }
    }

    override fun postCustomer(customer: PostCustomerRequest) {
        val id = getLastId().id!! + 1
        DatabaseHelper.runCommand {
            it.createUpdate("INSERT INTO customer(id, name, email) VALUES ($id, '${customer.name}', '${customer.email}')").execute()
        }
    }

    override fun putCustomer(id: Int, customer: PutCustomerRequest) {
        DatabaseHelper.runCommand {
            it.createUpdate("UPDATE customer SET name = '${customer.name}', email = '${customer.email}' WHERE id = $id").execute()
        }
    }

    override fun deleteCustomer(id: Int) {
        DatabaseHelper.runCommand {
            it.createUpdate("DELETE FROM customer WHERE id = $id").execute()
        }
    }
}