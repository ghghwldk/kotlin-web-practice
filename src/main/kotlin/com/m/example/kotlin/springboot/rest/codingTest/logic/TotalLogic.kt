package com.m.example.kotlin.springboot.rest.codingTest.logic

import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.output.ProblemOutput
import com.m.example.kotlin.springboot.rest.codingTest.output.요격시스템Result
import com.m.example.kotlin.springboot.rest.codingTest.solution.CodingTestSolution

class TotalLogic {
    var problemInput: ProblemInput? = null
    var solution: CodingTestSolution? = null
    var problemOutput:ProblemOutput? = null

    fun set(problemInput: ProblemInput, solution: CodingTestSolution, result: ProblemOutput){
        this.problemInput = problemInput
        this.solution = solution
        this.problemOutput = result
    }

    fun execute():Int{
        if (problemOutput is 요격시스템Result) {
            val count = (problemOutput as 요격시스템Result).count
            return count
        } else {
            println("Invalid result type.")
            return -1
        }
    }
}

/*
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


        if (result is 요격시스템Result) {
            val count = result.count
            return count
        } else {
            println("Invalid result type.")
            return -1
*/