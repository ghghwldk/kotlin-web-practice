package com.andrejusti.example.kotlin.springboot.rest.global.exception

import com.andrejusti.example.kotlin.springboot.rest.global.dto.ItemValidationError

data class ValidationException(val itemValidationErrors: List<ItemValidationError>) : RuntimeException()