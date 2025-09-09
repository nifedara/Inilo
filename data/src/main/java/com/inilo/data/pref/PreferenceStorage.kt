package com.inilo.data.pref

import kotlinx.coroutines.flow.Flow


interface PreferenceStorage {

    suspend fun saveLoginStatus(loggedIn: Boolean)

    fun getLoginStatus(): Flow<Boolean>


    suspend fun incrementCardAccessCount()

    fun getCardAccessCount(): Flow<Int>

    suspend fun saveToken(token: String)

    fun getToken(): Flow<String>

    suspend fun saveAuthColor(color: Long)

    fun getAuthColor(): Flow<Long>
}