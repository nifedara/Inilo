package com.developerni.inilo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.IniloScaffold
import com.developerni.inilo.ui.component.util.iniloFontFamily

enum class LoginRequiredScreenNavigation {
    Back, SignIn, SignUp
}
@Composable
fun LoginRequiredScreen(
    onRoute: (LoginRequiredScreenNavigation) -> Unit,
) {
    IniloScaffold(
        onBack = { onRoute(LoginRequiredScreenNavigation.Back) },
        pageTitle = "",
        appBarColor = Color(0xFFfbf6ef),
        backButtonColor = Color(0xFF9168f5),
        backButtonIconColor = Color(0xFFfbf6ef),
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { onRoute(LoginRequiredScreenNavigation.SignUp) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF9168f5), contentColor = Color(0xFFfbf6ef))
                ) {
                    Text(
                        text = stringResource(R.string.sign_up),
                        fontWeight = FontWeight.Medium,
                        fontFamily = iniloFontFamily,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedButton (
                    onClick = {onRoute(LoginRequiredScreenNavigation.SignIn)  },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF9168f5))
                ) {
                    Text(
                        text = stringResource(R.string.sign_in),
                        fontWeight = FontWeight.Medium,
                        fontFamily = iniloFontFamily,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(R.string.quick_action_card_icon),
                    modifier = Modifier
                        .size(240.dp),
                    tint = Color(0xFF9168f5)
                )

                Text(
                    text = stringResource(R.string.access_more_tips_free),
                    modifier = Modifier.padding(bottom = 24.dp),
                    fontWeight = FontWeight.Medium,
                    fontFamily = iniloFontFamily,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF3b1d38),
                    fontSize = 18.sp
                )
            }
        }
    }
}