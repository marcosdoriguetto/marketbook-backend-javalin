package com.marketbook.javalin.controller.request

import java.math.BigDecimal

data class PutBookRequest(
    var name: String?,
    var price: BigDecimal?
)
