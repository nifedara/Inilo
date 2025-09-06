package com.inilo.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val statusCode: Int,
    @Json(name = "message")
    val message: List<String>,
    val error: String? = null
)