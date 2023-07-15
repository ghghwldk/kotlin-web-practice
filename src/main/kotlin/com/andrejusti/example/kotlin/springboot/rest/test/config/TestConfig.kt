package com.andrejusti.example.kotlin.springboot.rest.test.config

import com.andrejusti.example.kotlin.springboot.rest.test.repository.TestRepository
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService2
import com.andrejusti.example.kotlin.springboot.rest.test.service.impl.TestService2Impl
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@RequiredArgsConstructor
class TestConfig(
        val testRepository: TestRepository
){
    @Bean
    fun testService2() : TestService2{
        return TestService2Impl(testRepository)
    }
}