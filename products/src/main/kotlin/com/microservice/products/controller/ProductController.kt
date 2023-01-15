package com.microservice.products.controller

import com.microservice.products.dto.ProductRequest
import com.microservice.products.dto.ProductResponse
import com.microservice.products.model.Product
import com.microservice.products.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class ProductController @Autowired constructor(val productService: ProductService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody productRequest: ProductRequest) {
        productService.createProduct(productRequest)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllProducts():Collection<ProductResponse> {
        return productService.getAllProducts()
    }

}