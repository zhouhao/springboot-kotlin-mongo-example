package com.saltyee.mongo.example.controller

import cn.dev33.satoken.annotation.SaCheckLogin
import cn.dev33.satoken.secure.BCrypt
import cn.dev33.satoken.stp.StpUtil
import com.saltyee.mongo.example.domain.LoginRequest
import com.saltyee.mongo.example.domain.NewUserRequest
import com.saltyee.mongo.example.domain.TokenResponse
import com.saltyee.mongo.example.domain.UserResponse
import com.saltyee.mongo.example.entity.User
import com.saltyee.mongo.example.repository.UserRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
class HomeCtrl(@Autowired val repo: UserRepository) {
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

    @PostMapping("/signup")
    fun signup(@RequestBody user: NewUserRequest): ResponseEntity<UserResponse> {
        val newUser = repo.save(User.from(user))
        return ResponseEntity.ok(UserResponse.from(newUser))
    }

    @PostMapping("/login")
    fun signup(@RequestBody request: LoginRequest): ResponseEntity<TokenResponse> {
        val user = repo.findByEmail(request.email)
        user?.let {
            if (BCrypt.checkpw(request.password, user.password)) {
                StpUtil.login(user.id)
                val refreshToken = StpUtil.getStpLogic()
                    .createTokenValue(user.id, StpUtil.getLoginDevice(), System.currentTimeMillis() + (180L * 24 * 3600 * 1000), emptyMap())
                return ResponseEntity.ok(TokenResponse(accessToken = StpUtil.getTokenValue(), refreshToken = refreshToken))
            }
        }

        return ResponseEntity.notFound().build()
    }
}