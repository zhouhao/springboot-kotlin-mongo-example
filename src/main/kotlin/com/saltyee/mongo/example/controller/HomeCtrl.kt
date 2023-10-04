package com.saltyee.mongo.example.controller

import cn.dev33.satoken.annotation.SaCheckLogin
import cn.dev33.satoken.stp.StpUtil
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
class HomeCtrl {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }

    @GetMapping("/sa-token")
    fun saTokenDemo(): String {
        StpUtil.login(10001)
        logger.info { StpUtil.getTokenInfo() }
        return "Hello Sa Token!"
    }

    @SaCheckLogin
    @GetMapping("/check-login")
    fun checkLogin(): String {
        return "I am logged In!"
    }
}