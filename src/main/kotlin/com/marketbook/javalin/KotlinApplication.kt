package com.marketbook.javalin

import com.marketbook.javalin.controller.CustomerController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.ApiBuilder.crud

class KotlinApplication

fun main() {
    val app = Javalin.create().start(8080)

    app.get("/customers") {
            ctx -> ctx.json(CustomerController::getCustomers)
    }
}
