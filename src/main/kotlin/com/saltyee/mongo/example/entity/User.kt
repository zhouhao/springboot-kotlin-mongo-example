package com.saltyee.mongo.example.entity

import cn.dev33.satoken.secure.BCrypt
import com.saltyee.mongo.example.domain.NewUserRequest
import com.saltyee.mongo.example.generator.SnowflakeIdGenerator
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
data class User(
    @Id
    val id: Long = SnowflakeIdGenerator.DEFAULT.nextId(),
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
) {
    companion object {
        fun from(newBlogRequest: NewUserRequest) = User(
            username = newBlogRequest.username,
            email = newBlogRequest.email,
            password = BCrypt.hashpw(newBlogRequest.password),
        )
    }
}