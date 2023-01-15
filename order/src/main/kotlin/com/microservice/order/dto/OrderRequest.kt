package com.microservice.order.dto

data class OrderRequest(val orderLineItems: List<OrderLineItemsDto>)
