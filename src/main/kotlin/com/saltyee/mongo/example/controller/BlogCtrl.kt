package com.saltyee.mongo.example.controller

import com.saltyee.mongo.example.domain.NewBlogRequest
import com.saltyee.mongo.example.entity.Blog
import com.saltyee.mongo.example.repository.BlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BlogCtrl(@Autowired val repo: BlogRepository) {
    @GetMapping("/blogs")
    fun getBlogs(): List<Blog> {
        return repo.findAll()
    }

    @GetMapping("/blogs/count")
    fun getCount(): Int {
        return repo.findAll().count()
    }

    @GetMapping("/blog/{id}")
    fun getBlogById(@PathVariable("id") id: Long): ResponseEntity<Blog> {
        val blog = repo.findById(id)
        return if (blog.isPresent) ResponseEntity.ok(blog.get()) else ResponseEntity
            .notFound().build()
    }

    @PostMapping("/blog")
    fun postBlog(@RequestBody request: NewBlogRequest): Blog {
        val blog = Blog.from(request)
        return repo.save(blog)
    }
}