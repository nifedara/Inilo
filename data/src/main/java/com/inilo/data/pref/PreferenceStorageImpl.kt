package com.inilo.data.pref


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceStorageImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): PreferenceStorage {

    companion object{
        private val LOGIN_STATUS = booleanPreferencesKey("login_status")
        private val CARD_ACCESS_COUNT = intPreferencesKey("card_access_count")
    }

    override suspend fun saveLoginStatus(loggedIn: Boolean) {
        dataStore.edit { preferences ->
            preferences[LOGIN_STATUS] = loggedIn
        }
    }

    override fun getLoginStatus(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[LOGIN_STATUS] ?: false
        }
    }

    override suspend fun incrementCardAccessCount() {
        dataStore.edit { preferences ->
            val newCount = (preferences[CARD_ACCESS_COUNT] ?: 0) + 1
            preferences[CARD_ACCESS_COUNT] = newCount
        }
    }

    override fun getCardAccessCount(): Flow<Int> {
        return dataStore.data.map { preferences ->
            preferences[CARD_ACCESS_COUNT] ?: 0
        }
    }
}
