package com.m.example.kotlin.springboot.rest.codingTest.logic

import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.output.ProblemOutput
import com.m.example.kotlin.springboot.rest.codingTest.output.요격시스템Result
import com.m.example.kotlin.springboot.rest.codingTest.solution.CodingTestSolution

class TotalLogicTemplate {
    private lateinit var problemInput: ProblemInput
    private lateinit var solution: CodingTestSolution

    fun printResult(result: ProblemOutput?) {
        if (result is 요격시스템Result) {
            println("Result Count: ${result.count}")
        } else {
            println("Invalid result type.")
        }
    }

    fun executeAndPrint():ProblemOutput? {
        val result = execute()
        printResult(result)
        return result
    }

    fun execute(): ProblemOutput? {
        return solution.execute(problemInput)
    }

    fun set(problemInput: ProblemInput, solution: CodingTestSolution) {
        this.problemInput = problemInput
        this.solution = solution
    }
}