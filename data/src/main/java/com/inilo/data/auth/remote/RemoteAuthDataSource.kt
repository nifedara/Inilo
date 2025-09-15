package com.inilo.data.auth.remote

import com.inilo.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface RemoteAuthDataSource {
    fun signUp(): Flow<Resource<Any>>
    fun signIn(): Flow<Resource<Any>>
}