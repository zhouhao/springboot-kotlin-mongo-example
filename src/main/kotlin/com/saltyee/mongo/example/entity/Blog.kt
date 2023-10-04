package com.saltyee.mongo.example.entity

import com.saltyee.mongo.example.domain.NewBlogRequest
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document("blogs")
data class Blog(
    @Id
    val id: ObjectId = ObjectId(),
    @Field("blog_id")
    val blogId: String = "",
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
            blogId = UUID.randomUUID().toString(),
            content = newBlogRequest.content,
            authorId = "1",
        )
    }
}