package com.saltyee.mongo.example.entity

import com.saltyee.mongo.example.domain.NewBlogRequest
import com.saltyee.mongo.example.generator.SnowflakeIdGenerator
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("blogs")
data class Blog(
    @Id
    val id: Long = SnowflakeIdGenerator.getDefault().nextId(),
    val title: String = "",
    val content: String = "",
    @Field("author_id")
    val authorId: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
) {
    companion object {
        fun from(newBlogRequest: NewBlogRequest) = Blog(
            title = newBlogRequest.title,
            content = newBlogRequest.content,
            authorId = "1",
        )
    }
}