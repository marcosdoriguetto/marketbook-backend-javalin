package com.marketbook.javalin.infra.mapper

import com.marketbook.javalin.enums.BookStatus
import com.marketbook.javalin.model.BookModel
import com.marketbook.javalin.model.CustomerModel
import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class BookMapper : ColumnMapper<BookModel> {
    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): BookModel {
        return BookModel(
                id = rs.getInt("id"),
            name = rs.getString("name"),
            price = rs.getBigDecimal("price"),
            status = BookStatus.valueOf(rs.getString("status")),
            customer = CustomerModel(
                id = rs.getInt("idCustomer"),
                name = rs.getString("nameCustomer"),
                email = rs.getString("emailCustomer")
            )
        )
    }
}