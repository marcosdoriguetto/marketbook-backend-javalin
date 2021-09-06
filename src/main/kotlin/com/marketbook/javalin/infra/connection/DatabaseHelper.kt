package com.marketbook.javalin.infra.connection

import org.jdbi.v3.core.statement.UnableToCreateStatementException
import org.jdbi.v3.core.statement.UnableToExecuteStatementException

internal object DatabaseHelper {
    private val connection = getTrackingDataSource()

    fun <T> runCommand(fn: T): T = try {
        connection.withHandle<T, Exception>(fn)
    } catch (ex: UnableToExecuteStatementException) {
        throw Exception(ex.cause)
    } catch (ex: UnableToCreateStatementException) {
        throw Exception("Could not create statement - ${ex.message}")
    }
}