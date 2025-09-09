package com.inilo.data.util

import com.inilo.data.pref.PreferenceStorageImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthHeaderInterceptor @Inject constructor(private val prefStorage: PreferenceStorageImpl) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        if (originalRequest.header("No-Authentication") != null) {
            return chain.proceed(originalRequest)
        }

        val token = runBlocking(Dispatchers.IO) {
            prefStorage.getToken().firstOrNull().orEmpty()
        }

        val authenticatedRequest = originalRequest.newBuilder().apply {
            if (token.isNotBlank()) {
                addHeader("Authorization", "Bearer $token")
            }
            addHeader("Accept", "application/json")
            addHeader("Content-Type", "application/json")
        }.build()

        return chain.proceed(authenticatedRequest)
    }
}
