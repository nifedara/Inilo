package com.developerni.inilo.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.developerni.inilo.ui.navigation.AppNavigation
import com.developerni.inilo.ui.viewModel.LoginStateViewModel

@Composable
fun EntryScreen() {

    val loginStateViewModel: LoginStateViewModel = hiltViewModel()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AppNavigation(
            viewModel = loginStateViewModel,
        )
    }
}