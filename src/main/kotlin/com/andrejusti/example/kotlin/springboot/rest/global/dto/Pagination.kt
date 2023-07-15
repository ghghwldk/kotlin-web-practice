package com.andrejusti.example.kotlin.springboot.rest.global.dto

data class Pagination(
        var page: Int? = null,
        var maxRecords: Int? = null
)