package com.microservice.products.dto

import java.math.BigDecimal

data class ProductResponse(
    val id: String,
    val name: String,
    val description: String,
    val price: BigDecimal,
)
