package com.microservice.order.service

import com.microservice.order.dto.OrderLineItemsDto
import com.microservice.order.dto.OrderRequest
import com.microservice.order.model.Order
import com.microservice.order.model.OrderLineItems
import com.microservice.order.repository.OrderRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.streams.toList

@Service
class OrderService @Autowired constructor(private val orderRepository: OrderRepository) {

    private val logger = KotlinLogging.logger {}

    fun placeOrder(orderRequest: OrderRequest) {
        val orderLineItems = orderRequest.orderLineItems.stream().map(this::mapToDto).toList()
        val order = Order(orderNumber = UUID.randomUUID().toString(), orderLineItemsList = orderLineItems)
        orderRepository.save(order)
    }

    private fun mapToDto(orderLineItemsDto: OrderLineItemsDto): OrderLineItems {
        return OrderLineItems(price = orderLineItemsDto.price,
            quantity = orderLineItemsDto.quantity,
            skuCode = orderLineItemsDto.skuCode)
    }
}