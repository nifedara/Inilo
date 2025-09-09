package com.developerni.inilo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.developerni.inilo.ui.component.TipCard
import com.developerni.inilo.ui.component.util.iniloFontFamily
import com.developerni.inilo.ui.viewModel.LoginStateViewModel

enum class SafetyAndSecurityScreenNavigation {
    Back, LoginRequired
}
@Composable
fun SafetyAndSecurityScreen(
    onRoute: (SafetyAndSecurityScreenNavigation) -> Unit,
    loginStateViewModel: LoginStateViewModel
) {
    IniloScaffold(
        onBack = { onRoute(SafetyAndSecurityScreenNavigation.Back) },
        pageTitle = "",
        appBarColor = Color(0xFF9168f5)
    ) {
        var showLoginDialog by remember { mutableStateOf(false) }

        if (showLoginDialog) {
            AlertDialog(
                onDismissRequest = { showLoginDialog = false },
                title = { Text("Login Required") },
                text = { Text("Please login to continue accessing more content.") },
                confirmButton = {
                    Button(onClick = {
                        showLoginDialog = false
                    }) {
                        Text("Login")
                    }
                }
            )
        }

        Column {
            Column(
                modifier = Modifier.background(Color(0xFF9168f5))
                    .fillMaxWidth()
                    .padding(top = 0.dp, start = 24.dp, end = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.safety),
                            contentDescription = stringResource(R.string.quick_action_card_icon),
                            modifier = Modifier.padding(8.dp).size(28.dp)
                        )
                    }
                }

                Text(
                    text = stringResource(R.string.safety_and_security),
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontWeight = FontWeight.Medium,
                    fontFamily = iniloFontFamily,
                    fontSize = 22.sp
                )
                Text(
                    text = stringResource(R.string.personal_safety_and_security_measures),
                    modifier = Modifier.padding(bottom = 6.dp),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(R.string.tips_available),
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier.padding(top = 32.dp, start = 24.dp, end = 24.dp)
            ) {
                TipCard(
                    onClick = {
                        if (loginStateViewModel.cardAccessCount.value > 5 && !loginStateViewModel.isLoggedIn.value) {
                            //showLoginDialog = true
                            onRoute(SafetyAndSecurityScreenNavigation.LoginRequired)
                        }
                        loginStateViewModel.incrementCardAccessCount()
                    }
                )
            }

            /*Column(
                modifier = Modifier
                    .padding(top = 180.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TipEmptyState()
            }*/
        }
    }
}