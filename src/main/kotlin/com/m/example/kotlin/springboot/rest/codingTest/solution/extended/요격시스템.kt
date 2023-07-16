package com.m.example.kotlin.springboot.rest.codingTest.solution.extended

import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.input.impl.Targets
import com.m.example.kotlin.springboot.rest.codingTest.output.ProblemOutput
import com.m.example.kotlin.springboot.rest.codingTest.output.요격시스템Result
import com.m.example.kotlin.springboot.rest.codingTest.solution.CodingTestSolution
import org.springframework.stereotype.Component

@Component
class 요격시스템 : CodingTestSolution() {
    override fun solution(input: ProblemInput): ProblemOutput {
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

        return 요격시스템Result(answer)
    }
}

