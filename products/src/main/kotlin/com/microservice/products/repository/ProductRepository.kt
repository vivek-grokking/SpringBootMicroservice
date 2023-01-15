package com.microservice.products.repository

import com.microservice.products.model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, String>