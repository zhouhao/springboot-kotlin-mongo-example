package com.saltyee.mongo.example.exception

import cn.dev33.satoken.util.SaResult
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val logger = KotlinLogging.logger {}

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handlerException(e: Exception): SaResult {
        logger.error(e) { e.message }
        return SaResult.error(e.message)
    }
}