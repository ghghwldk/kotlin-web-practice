package com.andrejusti.example.kotlin.springboot.rest.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import com.andrejusti.example.kotlin.springboot.rest.global.dto.ItemValidationError
import com.andrejusti.example.kotlin.springboot.rest.global.exception.ValidationException
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ValidationExceptionAdviceConfig : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ValidationException::class)
    fun handleClientException(validationException: ValidationException, request: WebRequest) =
            ResponseEntity<Collection<ItemValidationError>>(validationException.itemValidationErrors, HttpStatus.PRECONDITION_FAILED)
}