package com.inilo.data.pref

import kotlinx.coroutines.flow.Flow


interface PreferenceStorage {

    suspend fun saveLoginStatus(loggedIn: Boolean)

    fun getLoginStatus(): Flow<Boolean>


    suspend fun incrementCardAccessCount()

    fun getCardAccessCount(): Flow<Int>
}