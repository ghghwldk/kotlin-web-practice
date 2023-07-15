package com.m.example.kotlin.springboot.rest.product.domain.entity

import com.m.example.kotlin.springboot.rest.category.domain.entity.Category
import javax.persistence.*


@Entity
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,
        var description: String? = null,
        var value: Double? = null,
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "Product_Category",
                joinColumns = [JoinColumn(name = "product_id")],
                inverseJoinColumns = [JoinColumn(name = "category_id")])
        var categories: List<Category>? = null
)
