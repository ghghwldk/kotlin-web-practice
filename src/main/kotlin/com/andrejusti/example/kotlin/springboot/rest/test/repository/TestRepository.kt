package com.andrejusti.example.kotlin.springboot.rest.test.repository

import com.andrejusti.example.kotlin.springboot.rest.test.domain.entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<TestEntity, Long>{
}