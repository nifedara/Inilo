package com.inilo.data.pref


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceStorageImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): PreferenceStorage {

    companion object{
        private val LOGIN_STATUS = booleanPreferencesKey("login_status")
        private val CARD_ACCESS_COUNT = intPreferencesKey("card_access_count")
        private val TOKEN_KEY = stringPreferencesKey("token_key")
        private val AUTH_COLOR = longPreferencesKey("auth_color")
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

    override suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }

    }

    override fun getToken(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[TOKEN_KEY]?: ""
        }
    }

    override suspend fun saveAuthColor(color: Long) {
        dataStore.edit { preferences ->
            preferences[AUTH_COLOR] = color
        }

    }

    override fun getAuthColor(): Flow<Long> {
        return dataStore.data.map { preferences ->
            preferences[AUTH_COLOR]?: 0
        }
    }
}
