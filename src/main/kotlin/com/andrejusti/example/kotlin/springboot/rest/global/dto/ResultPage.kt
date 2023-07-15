package com.andrejusti.example.kotlin.springboot.rest.global.dto

data class ResultPage<T>(
        var totalRecords: Long? = null,
        var records: List<T>? = null
)