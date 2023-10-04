package com.saltyee.mongo.example.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class TokenResponse(@JsonProperty("access_token") val accessToken: String, @JsonProperty("refresh_token") val refreshToken: String)
