package com.inilo.data.auth.repository

import com.inilo.data.auth.remote.FirebaseDataSource
import com.inilo.data.auth.remote.RemoteAuthDataSource
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import com.inilo.data.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseDataSource: FirebaseDataSource,
    private val remoteAuthDataSource: RemoteAuthDataSource
): FirebaseRepository, RemoteAuthRepository {
    override suspend fun signUp(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> {
        return firebaseDataSource.signUp(authRequest)
    }

    override suspend fun signIn(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> {
        return firebaseDataSource.signIn(authRequest)
    }

    override suspend fun signUp(): Flow<Resource<Any>> {
        return remoteAuthDataSource.signUp()
    }

    override suspend fun signIn(): Flow<Resource<Any>> {
        return remoteAuthDataSource.signIn()
    }
}