package com.inilo.data.auth.repository

import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    suspend fun signUp(authRequest: FirebaseAuthRequest): Flow<FirebaseToken>
    suspend fun signIn(authRequest: FirebaseAuthRequest): Flow<FirebaseToken>
}