package com.microservice.order.dto

import java.math.BigDecimal

data class OrderLineItemsDto(var id:Long,
                              val skuCode: String,
                             val price: BigDecimal,
                             val quantity: Int )
