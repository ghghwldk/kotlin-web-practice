package com.andrejusti.example.kotlin.springboot.rest.codingTest

import com.andrejusti.example.kotlin.springboot.rest.codingTest.impl.Targets
import org.springframework.stereotype.Component

@Component
class 요격시스템 : CodingTestSolution() {
    override fun solution(input: ProblemInput): Int {
        var answer: Int = 0
        val targets = (input as Targets).targets
        targets.sortBy { it[1] }
        var destination = -1

        for (target in targets) {
            val (s, e) = target
            if (destination < s) {
                destination = e - 1
                answer++
            }
        }

        return answer
    }
}
