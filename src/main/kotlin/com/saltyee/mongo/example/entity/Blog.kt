package com.saltyee.mongo.example.entity

import com.saltyee.mongo.example.domain.NewBlogRequest
import com.saltyee.mongo.example.generator.SnowflakeIdGenerator
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("blog")
data class Blog(
    @Id
    val id: Long = SnowflakeIdGenerator.getDefault().nextId(),
    val title: String = "",
    val content: String = "",
    @Field("author_id")
    val authorId: Long,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
) {
    companion object {
        fun from(newBlogRequest: NewBlogRequest, authorId: Long) = Blog(
            title = newBlogRequest.title,
            content = newBlogRequest.content,
            authorId = authorId,
        )
    }
}