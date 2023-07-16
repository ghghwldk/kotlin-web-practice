package com.m.example.kotlin.springboot.rest.test.controller

import com.m.example.kotlin.springboot.rest.codingTest.solution.CodingTestSolution
import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.input.impl.Targets
import com.m.example.kotlin.springboot.rest.codingTest.solution.extended.요격시스템
import com.m.example.kotlin.springboot.rest.test.service.TestService
import com.m.example.kotlin.springboot.rest.test.service.TestService2
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class TestController(
        val testService: TestService,
        val testService2: TestService2
){
    val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    companion object {
        const val DOMAIN_URI: String = "/test"
        const val URL1: String = "$DOMAIN_URI/1"
        const val URL2: String = "$DOMAIN_URI/2"
        const val URL3: String = "$DOMAIN_URI/3"
    }

    @GetMapping(URL1)
    fun test(): String{
        val testMap: HashMap<String, String> = HashMap()
        testMap.put("a", "a")
        logger.info("test called")
        return testService.test()
    }

    @GetMapping(URL2)
    fun test2(): String{
        logger.info("test2 called")
        return testService2.test()
    }
}
