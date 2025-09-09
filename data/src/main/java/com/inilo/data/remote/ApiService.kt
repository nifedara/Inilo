package com.inilo.data.remote

import retrofit2.Response
import retrofit2.http.POST

interface ApiService {

    @POST("auth/signup")
    suspend fun signup(
    ): Response<Any>

    @POST("auth/signin")
    suspend fun signin(
    ): Response<Any>
}