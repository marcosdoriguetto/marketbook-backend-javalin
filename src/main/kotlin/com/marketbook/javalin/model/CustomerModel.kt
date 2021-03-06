package com.marketbook.javalin.model

data class CustomerModel(
    var id: Int? = null,
    var name: String,
    var email: String
) {
    operator fun not(): Boolean {
        return false
    }
}
