package com.inilo.data.auth.remote

import com.inilo.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface RemoteAuthDataSource {
    suspend fun signUp(): Flow<Resource<Any>>
    suspend fun signIn(): Flow<Resource<Any>>
}