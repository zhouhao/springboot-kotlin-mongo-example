package com.saltyee.mongo.example.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeCtrl {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }
}