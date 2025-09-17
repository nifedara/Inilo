package com.inilo.data.auth.remote

import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import kotlinx.coroutines.flow.Flow

interface FirebaseDataSource {

    fun signUp(authRequest: FirebaseAuthRequest): Flow<FirebaseToken>
    fun signIn(authRequest: FirebaseAuthRequest): Flow<FirebaseToken>
}