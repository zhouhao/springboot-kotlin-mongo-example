package com.saltyee.mongo.example.repository

import com.saltyee.mongo.example.entity.Blog
import org.springframework.data.mongodb.repository.MongoRepository

interface BlogRepository : MongoRepository<Blog, String> {
    fun findByBlogId(id: String): Blog?
}