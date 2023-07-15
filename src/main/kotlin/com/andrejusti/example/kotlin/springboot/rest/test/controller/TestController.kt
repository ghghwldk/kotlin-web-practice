package com.andrejusti.example.kotlin.springboot.rest.test.controller

import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService2
import com.andrejusti.example.kotlin.springboot.rest.test.service.impl.TestServiceImpl
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
class TestController(
        val testService: TestService,
        val testService2: TestService2
){
    val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    @GetMapping("/1")
    fun test(): String{
        logger.info("test called")
        return testService.test()
    }

    @GetMapping("/2")
    fun test2(): String{
        logger.info("test2 called")
        return testService2.test()
    }
}