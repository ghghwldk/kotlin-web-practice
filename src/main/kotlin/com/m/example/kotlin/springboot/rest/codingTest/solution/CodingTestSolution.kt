package com.m.example.kotlin.springboot.rest.codingTest.solution

import com.m.example.kotlin.springboot.rest.codingTest.input.ProblemInput
import com.m.example.kotlin.springboot.rest.codingTest.output.ProblemOutput

abstract class CodingTestSolution {
    abstract fun execute(input: ProblemInput): ProblemOutput
}
