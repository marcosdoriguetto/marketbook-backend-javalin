package com.marketbook.javalin.controller.request

data class PostCustomerRequest(
    val name: String,
    val email: String
)