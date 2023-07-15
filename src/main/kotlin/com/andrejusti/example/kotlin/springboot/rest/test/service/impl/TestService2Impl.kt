package com.andrejusti.example.kotlin.springboot.rest.test.service.impl

import com.andrejusti.example.kotlin.springboot.rest.test.controller.TestController
import com.andrejusti.example.kotlin.springboot.rest.test.repository.TestRepository
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService2
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class TestService2Impl(
        val testRepository: TestRepository
) : TestService2{
    val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    override fun test(): String{
        val testEntities = testRepository.findAll()
        logger.info("--finded--")
        return "test2"
    }
}