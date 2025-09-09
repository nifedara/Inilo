package com.developerni.inilo.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inilo.data.pref.PreferenceStorageImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginStateViewModel @Inject constructor(
    private val preferenceStorage: PreferenceStorageImpl
): ViewModel() {
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn
    private val _authColor = MutableStateFlow(0.toLong())
    val authColor: StateFlow<Long> = _authColor

    private val _cardAccessCount = MutableStateFlow(0)
    val cardAccessCount: StateFlow<Int> = _cardAccessCount

    init {
        getLoginStatus()
        getCardAccessCount()
    }

    fun saveLoginStatus(isLoggedIn: Boolean) {
        viewModelScope.launch {
            preferenceStorage.saveLoginStatus(loggedIn = isLoggedIn)
        }
    }

    fun getLoginStatus() {
        viewModelScope.launch {
            preferenceStorage.getLoginStatus().collectLatest {  loginStatus ->
                _isLoggedIn.value = loginStatus
            }
        }
    }

    fun incrementCardAccessCount () {
        viewModelScope.launch {
            preferenceStorage.incrementCardAccessCount()
        }
    }

    fun getCardAccessCount() {
        viewModelScope.launch {
            preferenceStorage.getCardAccessCount().collectLatest {  cardAccessCount ->
                _cardAccessCount.value = cardAccessCount
            }
        }
    }

    fun saveAuthColor(authColor: Long) {
        viewModelScope.launch {
            preferenceStorage.saveAuthColor(color = authColor)
        }
    }

    fun getAuthColor() {
        viewModelScope.launch {
            preferenceStorage.getAuthColor().collectLatest {  authColor ->
                _authColor.value = authColor
            }
        }
    }
}