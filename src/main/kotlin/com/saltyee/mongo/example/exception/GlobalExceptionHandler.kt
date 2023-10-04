package com.saltyee.mongo.example.exception

import cn.dev33.satoken.util.SaResult
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val logger = KotlinLogging.logger {}

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handlerException(e: Exception): ResponseEntity<SaResult> {
        logger.error(e) { e.message }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(SaResult.error(e.message))
    }
}