package com.microservice.products.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(value = "product")
data class Product(
    @Id var id: ObjectId = ObjectId.get(),
    val name: String,
    val description: String,
    val price: BigDecimal,
)