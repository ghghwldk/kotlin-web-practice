package com.m.example.kotlin.springboot.rest.product.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.m.example.kotlin.springboot.rest.product.domain.entity.Product

@Repository
interface ProductRepository : JpaRepository<Product, Long> {

    fun existsByCategoriesId(id: Long): Boolean

    fun existsByNameIgnoreCase(name: String?): Boolean

    fun existsByIdNotAndNameIgnoreCase(id: Long, name: String?): Boolean
}