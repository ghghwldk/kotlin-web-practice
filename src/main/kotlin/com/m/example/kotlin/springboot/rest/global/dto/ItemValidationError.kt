package com.m.example.kotlin.springboot.rest.global.dto

open class ItemValidationError(
        var errorLocation: String,
        var errorType: String,
        var message: String? = null,
        var context: List<Any>? = null
)

