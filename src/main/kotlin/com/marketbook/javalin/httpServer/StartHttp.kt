package com.marketbook.javalin.httpServer

import com.marketbook.javalin.controller.CustomerController
import com.marketbook.javalin.controller.request.PostCustomerRequest
import com.marketbook.javalin.controller.request.PutCustomerRequest
import com.marketbook.javalin.factory.ApplicationFactory
import com.marketbook.javalin.model.CustomerModel
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

class StartHttp {
    fun start() {
        val app = Javalin.create().start(8080)

        app.routes {
            path("customers") {
                get {
                    it.json(ApplicationFactory.customerController.getCustomers())
                }
                post {
                    val customer = it.body<PostCustomerRequest>()
                    it.json(ApplicationFactory.customerController.createCustomer(customer))
                }
                path(":id") {
                    get {
                        it.json(ApplicationFactory.customerController.getCustomer(it.pathParam("id").toInt()))
                    }
                    put {
                        val customer = it.body<PutCustomerRequest>()
                        it.json(ApplicationFactory.customerController.updateCustomer(it.pathParam("id").toInt(), customer))
                    }
                    delete {
                        it.json(ApplicationFactory.customerController.removeCustomer(it.pathParam("id").toInt()))
                    }
                }
            }
        }
    }
}