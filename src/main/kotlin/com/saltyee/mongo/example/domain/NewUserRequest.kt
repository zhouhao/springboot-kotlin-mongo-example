package com.saltyee.mongo.example.domain

data class NewUserRequest(
    val username: String,
    val email: String,
    val password: String,
)
