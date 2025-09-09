package com.developerni.inilo.ui.component.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import kotlin.reflect.KProperty

class IniloScaffoldState(
    private var showOverlay: MutableState<Boolean>,
    private var showMessage: MutableState<Boolean>,
    private var showLoading: MutableState<Boolean>,
    private var upLoading: MutableState<Boolean>,
    private var loadingMessage: MutableState<String>,
    private var message: MutableState<String>,
    private var messageType: MutableState<MessageType>,
    private var onDismiss: (() -> Unit)? = null,
) {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): IniloScaffoldState {
        return this
    }

    val isLoading
        get() = showLoading.value

    val uLoading
        get() = upLoading.value


    val overlayVisible
        get() = showOverlay.value


    val loadingText
        get() = loadingMessage.value

    val messageText
        get() = message.value

    val messageTypeValue
        get() = messageType.value

    val displayMessage
        get() = showMessage.value

    val onDismissAction
        get() = onDismiss

    fun upLoading() {
        this.upLoading.value = true
    }

    fun doneLoading() {
        this.upLoading.value = false
    }

    fun showLoading(loadingMessage: String = "Please wait") {
        this.showOverlay.value = true
        this.showLoading.value = true
        this.loadingMessage.value = loadingMessage
    }

    fun dismissOverlay() {
        this.showOverlay.value = false
        this.showLoading.value = false
    }

    fun showMessage(
        text: String,
        messageType: MessageType = MessageType.Success,
        onDismiss: (() -> Unit)? = null
    ) {
        this.message.value = text
        this.showMessage.value = true
        this.messageType.value = messageType
        this.onDismiss = onDismiss
    }

    fun clearMessage() {
        this.showMessage.value = false
    }
}


enum class MessageType(val color: Color) {
    Success(Color(0xFF086343)), Error(Color(0xFFDE1C22)), Info(Color(0xFFFC9700))
}

@Composable
fun rememberIniloScaffoldState(
    showOverlay: MutableState<Boolean> = remember { mutableStateOf(false) },
    showError: MutableState<Boolean> = remember { mutableStateOf(false) },
    showLoading: MutableState<Boolean> = remember { mutableStateOf(false) },
    upLoading: MutableState<Boolean> = remember { mutableStateOf(false) },
    loadingMessage: MutableState<String> = remember { mutableStateOf("") },
    messageText: MutableState<String> = remember { mutableStateOf("") },
    messageType: MutableState<MessageType> = remember { mutableStateOf(MessageType.Success) },
) = remember(showLoading, upLoading, loadingMessage, messageText) {
    IniloScaffoldState(
        showOverlay,
        showError,
        showLoading,
        upLoading,
        loadingMessage,
        messageText,
        messageType,
    )
}