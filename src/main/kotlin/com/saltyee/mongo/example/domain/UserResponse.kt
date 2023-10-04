package com.saltyee.mongo.example.domain

import com.saltyee.mongo.example.entity.User

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String,
    val createdAt: Long,
    val updatedAt: Long,
) {
    companion object {
        fun from(user: User) = UserResponse(
            id = user.id,
            username = user.username,
            email = user.email,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt,
        )

    }
}
