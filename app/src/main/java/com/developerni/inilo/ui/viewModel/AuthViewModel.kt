package com.developerni.inilo.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.domain.usecase.auth.SignInUseCase
import com.inilo.domain.usecase.auth.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase,
): ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading


    fun signIn(authRequest: FirebaseAuthRequest) {
        _loading.value = true
        viewModelScope.launch {

            signInUseCase.invoke(authRequest).collect { firebaseToken ->
                _loading.value = false
                Log.v("token", firebaseToken.token)
            }
        }
    }

    fun signUp(authRequest: FirebaseAuthRequest) {
        _loading.value = true
        viewModelScope.launch {

            signUpUseCase.invoke(authRequest).collect { firebaseToken ->
                _loading.value = false
                Log.v("token", firebaseToken.token)
            }
        }
    }
}