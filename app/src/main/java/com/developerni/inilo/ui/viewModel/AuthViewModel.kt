package com.developerni.inilo.ui.viewModel

import androidx.lifecycle.viewModelScope
import com.developerni.inilo.ui.viewModel.util.AuthVMState
import com.developerni.inilo.ui.viewModel.util.IniloViewModel
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.pref.PreferenceStorageImpl
import com.inilo.domain.usecase.auth.firebase.SignInUseCase
import com.inilo.domain.usecase.auth.firebase.SignUpUseCase
import com.inilo.domain.usecase.auth.remote.RemoteSignInUseCase
import com.inilo.domain.usecase.auth.remote.RemoteSignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val firebaseSignInUseCase: SignInUseCase,
    private val firebaseSignUpUseCase: SignUpUseCase,
    private val remoteSignInUseCase: RemoteSignInUseCase,
    private val remoteSignUpUseCase: RemoteSignUpUseCase,
    private val preferenceStorage: PreferenceStorageImpl
): IniloViewModel<AuthVMState>(AuthVMState.InitialState) {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading


    fun signIn(authRequest: FirebaseAuthRequest) {
        _loading.value = true
        setScreenState(AuthVMState.LoadingState)
        viewModelScope.launch {

            firebaseSignInUseCase.invoke(authRequest).collect { firebaseToken ->
                _loading.value = false
                remoteSignInUseCase.invoke().collect {
                    if (it.isSuccess()) {
                        preferenceStorage.saveLoginStatus(true)
                        setScreenState(AuthVMState.SignInSuccessState(currentVMStateValue.vmData.copy(message = "sign in successful")))
                    } else {
                        setScreenState(AuthVMState.Error(currentVMStateValue.vmData.copy(error = it.message)))
                    }
                }
            }
        }
    }

    fun signUp(authRequest: FirebaseAuthRequest) {
        _loading.value = true
        setScreenState(AuthVMState.LoadingState)
        viewModelScope.launch {

            firebaseSignUpUseCase.invoke(authRequest).collect { firebaseToken ->
                _loading.value = false
                remoteSignUpUseCase.invoke().collect {
                    if (it.isSuccess()) {
                        preferenceStorage.saveLoginStatus(true)
                        setScreenState(AuthVMState.SignUpSuccessState(currentVMStateValue.vmData.copy(message = "sign up successful")))
                    } else {
                        setScreenState(AuthVMState.Error(currentVMStateValue.vmData.copy(error = it.message)))
                    }
                }
            }
        }
    }
}