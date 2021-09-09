package com.marketbook.javalin.infra.connection

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin

const val mySqlDriverClass = "com.mysql.cj.jdbc.Driver"

internal fun getTrackingDataSource() = HikariConfig().let {
    it.driverClassName = mySqlDriverClass
    it.connectionInitSql = "SELECT 1"
    it.connectionTestQuery = "SELECT 1"
    it.jdbcUrl = "jdbc:mysql://localhost:3306/marketbook?useTimezone=true&serverTimezone=UTC"
    it.username = "root"
    it.password = "root"

    HikariDataSource(it)
}.let { dataSource ->
    Jdbi.create(dataSource)
        .installPlugin(KotlinPlugin())
        .installPlugin(KotlinSqlObjectPlugin())
    }