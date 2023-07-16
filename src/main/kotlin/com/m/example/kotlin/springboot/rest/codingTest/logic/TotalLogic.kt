package com.m.example.kotlin.springboot.rest.codingTest.logic

import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.output.ProblemOutput
import com.m.example.kotlin.springboot.rest.codingTest.output.요격시스템Result
import com.m.example.kotlin.springboot.rest.codingTest.solution.CodingTestSolution

class TotalLogic<T> {
    private var problemInput: ProblemInput? = null
    private var solution: CodingTestSolution? = null
    private var problemOutput: T? = null

    fun set(problemInput: ProblemInput, solution: CodingTestSolution) {
        this.problemInput = problemInput
        this.solution = solution
//        this.problemOutput = result
    }

    fun execute(): ProblemOutput? {
//        val result = problemOutput as? 요격시스템Result
//                ?: throw IllegalStateException("Invalid result type.")
        return problemInput?.let { solution?.execute(it) }
    }
}
