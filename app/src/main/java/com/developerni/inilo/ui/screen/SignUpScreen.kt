package com.developerni.inilo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.IniloScaffold
import com.developerni.inilo.ui.component.util.iniloFontFamily
import com.developerni.inilo.ui.viewModel.AuthViewModel
import com.inilo.data.model.FirebaseAuthRequest

enum class SignUpScreenNavigation {
    Back, SignUp
}

@Composable
fun SignUpScreen(
    onRoute: (SignUpScreenNavigation) -> Unit,
) {
    val authViewModel: AuthViewModel = hiltViewModel()

    IniloScaffold(
        onBack = { onRoute(SignUpScreenNavigation.Back) },
        pageTitle = "Sign up",
        appBarColor = Color(0xFFfbf6ef),
        backButtonColor = Color(0xFF9168f5),
        backButtonIconColor = Color(0xFFfbf6ef),
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

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
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

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
                colors = ButtonDefaults.buttonColors(Color(0xFF9168f5), contentColor = Color(0xFFfbf6ef))
            ) {
                Text(
                    text = stringResource(R.string.complete),
                    fontWeight = FontWeight.Medium,
                    fontFamily = iniloFontFamily,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}