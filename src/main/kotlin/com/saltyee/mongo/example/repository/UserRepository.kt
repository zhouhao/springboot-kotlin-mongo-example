package com.saltyee.mongo.example.repository

import com.saltyee.mongo.example.entity.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, Long> {
    fun findByEmail(email: String): User?
}