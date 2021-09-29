package com.marketbook.javalin.infra.mapper

import com.marketbook.javalin.model.CustomerModel
import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class CustomerMapper: ColumnMapper<CustomerModel> {
    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): CustomerModel {
        return CustomerModel(
            id = rs.getInt("id"),
            name = rs.getString("name"),
            email = rs.getString("email")
        )
    }
}