package com.andrejusti.example.kotlin.springboot.rest.test.config

import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService2
import com.andrejusti.example.kotlin.springboot.rest.test.service.impl.TestService2Impl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestConfig {
    @Bean
    fun testService2() : TestService2{
        return TestService2Impl()
    }
}