package com.inilo.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class FirebaseAuthRequest(
    @Json(name = "email")
    val email: String,

    @Json(name = "password")
    val password: String,
)
