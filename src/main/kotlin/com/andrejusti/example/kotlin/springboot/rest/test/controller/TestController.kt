package com.andrejusti.example.kotlin.springboot.rest.test.controller

import com.andrejusti.example.kotlin.springboot.rest.codingTest.CodingTestSolution
import com.andrejusti.example.kotlin.springboot.rest.codingTest.ProblemInput
import com.andrejusti.example.kotlin.springboot.rest.codingTest.impl.Targets
import com.andrejusti.example.kotlin.springboot.rest.codingTest.요격시스템
import com.andrejusti.example.kotlin.springboot.rest.global.exception.ValidationException
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService2
import com.andrejusti.example.kotlin.springboot.rest.test.service.impl.TestServiceImpl
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

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

    @GetMapping
    fun test3(): Int{
        val targets = arrayOf(
                intArrayOf(2, 3),
                intArrayOf(4, 5),
                intArrayOf(6, 7),
                intArrayOf(8, 9),
                intArrayOf(10, 11),
                intArrayOf(12, 13),
                intArrayOf(14, 15),
                intArrayOf(16, 17)
        )

        val input: ProblemInput = Targets(targets)
        val solution: CodingTestSolution = 요격시스템()
        val result = solution.solution(input)
        println("Maximum number of non-overlapping targets: $result")

        return result
    }
}
