package com.m.example.kotlin.springboot.rest.global.exception

import com.m.example.kotlin.springboot.rest.global.dto.ItemValidationError

data class ValidationException(val itemValidationErrors: List<ItemValidationError>) : RuntimeException()