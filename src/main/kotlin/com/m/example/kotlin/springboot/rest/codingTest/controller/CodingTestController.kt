package com.m.example.kotlin.springboot.rest.codingTest.controller

import com.m.example.kotlin.springboot.rest.codingTest.solution.CodingTestSolution
import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.input.impl.Targets
import com.m.example.kotlin.springboot.rest.codingTest.output.ProblemOutput
import com.m.example.kotlin.springboot.rest.codingTest.output.SolutionResult
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
class CodingTestController(
        val codingTestSolution: CodingTestSolution
){
    val logger: Logger = LoggerFactory.getLogger(CodingTestController::class.java)

    companion object {
        const val DOMAIN_URI: String = "/coding-test"
        const val URL1: String = "$DOMAIN_URI/요격시스템"
    }

    @GetMapping(URL1)
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

        val input: ProblemInput? = Targets(targets)
        val solution: CodingTestSolution? = 요격시스템()
        val result: ProblemOutput? = input?.let { solution?.solution(it) }

        if (result is SolutionResult) {
            val count = result.count
            println("Maximum number of non-overlapping targets: $count")
            return count
        } else {
            println("Invalid result type.")
            return -1
        }
    }
}
