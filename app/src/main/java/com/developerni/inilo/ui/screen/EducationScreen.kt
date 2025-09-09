package com.developerni.inilo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

enum class EducationScreenNavigation {
    Back, LoginRequired
}
@Composable
fun EducationScreen(
    onRoute: (EducationScreenNavigation) -> Unit,
    loginStateViewModel: LoginStateViewModel
) {
    val educationColor = Color(0xFF9168f5)
    val textColor = Color(0xFFfbf6ef)

    LaunchedEffect(Unit) {
        loginStateViewModel.saveAuthColor(0xFF9168f5)
    }
    IniloScaffold(
        onBack = { onRoute(EducationScreenNavigation.Back) },
        pageTitle = "",
        appBarColor = educationColor
    ) {
        Column {
            Column(
                modifier = Modifier.background(educationColor)
                    .fillMaxWidth()
                    .padding(top = 0.dp, start = 24.dp, end = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(containerColor = textColor),
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.education),
                            contentDescription = stringResource(R.string.quick_action_card_icon),
                            modifier = Modifier.padding(8.dp).size(30.dp),
                        )
                    }
                }

                Text(
                    text = stringResource(R.string.education_and_learning),
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontWeight = FontWeight.Medium,
                    fontFamily = iniloFontFamily,
                    fontSize = 22.sp,
                    color = textColor
                )
                Text(
                    text = stringResource(R.string.smart_learning_techniques_and_resources),
                    modifier = Modifier.padding(bottom = 6.dp),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = textColor
                )
                Text(
                    text = stringResource(R.string.tips_available),
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = textColor
                )
            }

            Column(
                modifier = Modifier.padding(top = 32.dp, start = 24.dp, end = 24.dp)
            ) {
                TipCard(
                    onClick = {
                        if (loginStateViewModel.cardAccessCount.value > 5 && !loginStateViewModel.isLoggedIn.value) {
                            onRoute(EducationScreenNavigation.LoginRequired)
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