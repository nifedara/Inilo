package com.developerni.inilo.ui.viewModel.util

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class AuthVMState(val vmData: AuthVMData = AuthVMData()): IniloVMState {

    @Parcelize
    data object InitialState: AuthVMState()

    @Parcelize
    data object LoadingState: AuthVMState()

    @Parcelize
    data class SignUpSuccessState(val data: AuthVMData): AuthVMState(data)

    @Parcelize
    data class SignInSuccessState(val data: AuthVMData): AuthVMState(data)

    @Parcelize
    data class Error(val data: AuthVMData): AuthVMState(data)
}

@Parcelize
data class AuthVMData(
    val id: String? = null,
    val status: String? = null,
    val message: String? = null,
    val error: String? = null,
) : Parcelable