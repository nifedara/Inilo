package com.inilo.data.auth.repository

import com.inilo.data.util.Resource
import kotlinx.coroutines.flow.Flow



interface RemoteAuthRepository {
    suspend fun signUp(): Flow<Resource<Any>>
    suspend fun signIn(): Flow<Resource<Any>>
}