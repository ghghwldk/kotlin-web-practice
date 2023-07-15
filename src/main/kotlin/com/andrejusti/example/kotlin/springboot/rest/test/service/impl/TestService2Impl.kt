package com.andrejusti.example.kotlin.springboot.rest.test.service.impl

import com.andrejusti.example.kotlin.springboot.rest.test.controller.TestController
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService2
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class TestService2Impl : TestService2{
    val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    override fun test(): String{
        logger.info("--executed--")
        return "test2"
    }
}