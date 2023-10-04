package com.saltyee.mongo.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMongoApplication

fun main(args: Array<String>) {
    runApplication<KotlinMongoApplication>(*args)
}
