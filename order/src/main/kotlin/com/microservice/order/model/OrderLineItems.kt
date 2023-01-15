package com.microservice.order.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "t_order_line_item")
data class OrderLineItems(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Long? = null,
    val skuCode: String,
    val price: BigDecimal,
    val quantity: Int
)
