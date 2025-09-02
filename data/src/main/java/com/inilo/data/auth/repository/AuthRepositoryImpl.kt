package com.inilo.data.auth.repository

import com.inilo.data.auth.remote.FirebaseDataSource
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataSource: FirebaseDataSource
): FirebaseRepository {
    override suspend fun signUp(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> = flow {
        dataSource.signUp(authRequest).collect{
            emit(it)
        }
    }

    override suspend fun signIn(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> = flow {
        dataSource.signIn(authRequest).collect{
            emit(it)
        }
    }
}