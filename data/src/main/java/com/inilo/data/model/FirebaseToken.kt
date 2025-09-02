package com.inilo.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class FirebaseToken (

    @Json(name = "token")
    var token  : String = "",
)