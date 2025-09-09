package com.developerni.inilo.ui.viewModel.util

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class IniloViewModel<T : IniloVMState>(
    initialState: T
) : ViewModel() {

    private val _vmState: MutableStateFlow<T> = MutableStateFlow(initialState)
    val vmState: MutableStateFlow<T> = _vmState

    val currentVMStateValue
        get() = _vmState.value

    fun setScreenState(state: T) {
        _vmState.value = state
    }


}


interface IniloVMState: Parcelable