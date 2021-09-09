package com.marketbook.javalin

import com.marketbook.javalin.controller.CustomerController
import com.marketbook.javalin.httpServer.StartHttp
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.ApiBuilder.crud
import java.sql.SQLException

class KotlinApplication

fun main() {
    StartHttp().start()
}
