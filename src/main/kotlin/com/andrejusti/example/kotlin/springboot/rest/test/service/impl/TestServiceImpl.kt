package com.andrejusti.example.kotlin.springboot.rest.test.service.impl

import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService
import org.springframework.stereotype.Service

@Service
class TestServiceImpl : TestService {
    override fun test(): String
        = "hi"
}