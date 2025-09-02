package com.inilo.data.auth.repository

import com.inilo.data.auth.remote.FirebaseDataSource
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataSource: FirebaseDataSource
): FirebaseRepository {
    override suspend fun signUp(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> {
        return dataSource.signUp(authRequest)
    }

    override suspend fun signIn(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> {
        return dataSource.signIn(authRequest)
    }
}