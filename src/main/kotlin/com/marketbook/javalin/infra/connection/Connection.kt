package com.marketbook.javalin.infra.connection

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin

const val sqlDriverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver"

internal fun getTrackingDataSource() = HikariConfig().let {
    it.driverClassName = sqlDriverClass
    it.connectionInitSql = "SELECT 1"
    it.connectionTestQuery = "SELECT 1"
    it.jdbcUrl = "jdbc:mysql://localhost:$3306/marketbook";
    it.username = "root"
    it.password = "88237254"

    HikariDataSource(it)
}.let { dataSource ->
    Jdbi.create(dataSource)
        .installPlugin(KotlinPlugin())
        .installPlugin(KotlinSqlObjectPlugin())
}

