package com.microservice.products.service

import com.microservice.products.dto.ProductRequest
import com.microservice.products.dto.ProductResponse
import com.microservice.products.model.Product
import com.microservice.products.repository.ProductRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class ProductService @Autowired constructor(private val productRepository: ProductRepository) {
    private val logger = KotlinLogging.logger {}
    fun createProduct(productRequest: ProductRequest) {
        val product = Product(
            name = productRequest.name,
            description = productRequest.description,
            price = productRequest.price)

        productRepository.save(product)
        logger.info{ "product $product is saved" }
    }

    fun getAllProducts(): Collection<ProductResponse> {
        val products = productRepository.findAll()
        return products.stream().map(this::mapToProductResponse).toList()
    }

    private fun mapToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id.toString(),
            name = product.name,
            description = product.description,
            price = product.price
        )
    }

}