package com.m.example.kotlin.springboot.rest.test.domain.entity

import com.m.example.kotlin.springboot.rest.category.domain.entity.Category
import javax.persistence.*

//class TestEntity {
//}
@Entity
data class TestEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null
)