package com.marketbook.javalin.model

import com.marketbook.javalin.enums.BookStatus
import java.math.BigDecimal

data class BookModel(
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var status: BookStatus,
    var customer: CustomerModel? = null
    )
