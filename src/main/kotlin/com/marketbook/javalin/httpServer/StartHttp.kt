package com.marketbook.javalin.httpServer

import com.marketbook.javalin.controller.CustomerController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get

class StartHttp {
    fun start() {
        val app = Javalin.create().start(8080)

        app.routes {
            get("/customers") {
                it.json(CustomerController::getCustomers)
            }
        }
    }
}