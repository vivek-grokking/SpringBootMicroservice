package com.microservice.order.controller

import com.microservice.order.dto.OrderRequest
import com.microservice.order.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/order")
class OrderController @Autowired constructor(val orderService: OrderService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun placeOrder(@RequestBody orderRequest: OrderRequest) {
        orderService.placeOrder(orderRequest)
    }

}