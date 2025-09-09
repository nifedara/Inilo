package com.developerni.inilo.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.IniloScaffold
import com.developerni.inilo.ui.component.util.iniloFontFamily
import com.developerni.inilo.ui.viewModel.AuthViewModel
import com.developerni.inilo.ui.viewModel.LoginStateViewModel
import com.developerni.inilo.ui.viewModel.util.AuthVMState
import com.inilo.data.model.FirebaseAuthRequest

enum class SignUpScreenNavigation {
    Back, SignUpComplete
}

@Composable
fun SignUpScreen(
    onRoute: (SignUpScreenNavigation) -> Unit,
    loginStateViewModel: LoginStateViewModel
) {
    val authViewModel: AuthViewModel = hiltViewModel()
    val vmState = authViewModel.vmState.collectAsState()

    loginStateViewModel.getAuthColor()
    val authColor = loginStateViewModel.authColor.collectAsState().value

    LaunchedEffect(vmState.value) {
        when (vmState.value) {
            is AuthVMState.Error -> {}
            is AuthVMState.SignUpSuccessState -> {
                onRoute(SignUpScreenNavigation.SignUpComplete)
            }
            else -> {}
        }
    }

    IniloScaffold(
        onBack = { onRoute(SignUpScreenNavigation.Back) },
        pageTitle = "Sign up",
        appBarColor = Color(0xFFfbf6ef),
        backButtonColor = Color(authColor),
        backButtonIconColor = Color(0xFFfbf6ef),
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(
                    text = stringResource(R.string.enter_your_email),
                    fontWeight = FontWeight.Normal,
                    fontFamily = iniloFontFamily,
                    fontSize = 14.sp
                ) },
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.email),
                        contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(
                    text = stringResource(R.string.enter_a_password),
                    fontWeight = FontWeight.Normal,
                    fontFamily = iniloFontFamily,
                    fontSize = 14.sp
                ) },
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.password),
                        contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = if (showPassword) {
                            Icons.Filled.Visibility }
                        else { Icons.Filled.VisibilityOff },
                        contentDescription = null,
                        modifier = Modifier.clickable { showPassword = !showPassword }
                            .size(18.dp)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                visualTransformation = if (!showPassword) PasswordVisualTransformation() else VisualTransformation.None,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    authViewModel.signUp(
                        authRequest = FirebaseAuthRequest(
                            email = email,
                            password = password
                        )
                    )
                },
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(authColor), contentColor = Color(0xFFfbf6ef))
            ) {
                Text(
                    text = stringResource(R.string.complete),
                    fontWeight = FontWeight.Medium,
                    fontFamily = iniloFontFamily,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(6.dp)
                )
            }
        }
    }
}