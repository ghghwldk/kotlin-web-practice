package com.m.example.kotlin.springboot.rest.codingTest.logic

import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.output.ProblemOutput
import com.m.example.kotlin.springboot.rest.codingTest.output.요격시스템Result
import com.m.example.kotlin.springboot.rest.codingTest.solution.CodingTestSolution

class TotalLogic {
    private lateinit var problemInput: ProblemInput
    private lateinit var solution: CodingTestSolution
    private lateinit var problemOutput: ProblemOutput

    fun set(problemInput: ProblemInput, solution: CodingTestSolution, result: ProblemOutput) {
        this.problemInput = problemInput
        this.solution = solution
        this.problemOutput = result
    }

    class TotalLogic {
        private lateinit var problemInput: ProblemInput
        private lateinit var solution: CodingTestSolution
        private lateinit var problemOutput: ProblemOutput

        fun set(problemInput: ProblemInput, solution: CodingTestSolution, result: ProblemOutput) {
            this.problemInput = problemInput
            this.solution = solution
            this.problemOutput = result
        }

        fun execute(): Int {
            val result = problemOutput as? 요격시스템Result
                    ?: throw IllegalStateException("Invalid result type.")

            return result.count
        }
    }

}
