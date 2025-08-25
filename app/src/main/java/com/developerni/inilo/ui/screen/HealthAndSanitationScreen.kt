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
import com.developerni.inilo.ui.component.TipEmptyState
import com.developerni.inilo.ui.component.util.iniloFontFamily

@Composable
fun HealthAndSanitationScreen(
    onBack: () -> Unit
) {
    IniloScaffold(
        onBack = { onBack() },
        pageTitle = "",
        appBarColor = Color(0xFFD7D9CE)
    ) {
        Column {
            Column(
                modifier = Modifier.background(Color(0xFFD7D9CE))
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
                            painter = painterResource(R.drawable.health),
                            contentDescription = stringResource(R.string.quick_action_card_icon),
                            modifier = Modifier.padding(8.dp).size(28.dp)
                        )
                    }
                }

                Text(
                    text = stringResource(R.string.health_and_sanitation),
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontWeight = FontWeight.Medium,
                    fontFamily = iniloFontFamily,
                    fontSize = 22.sp
                )
                Text(
                    text = stringResource(R.string.hygiene_practices_and_sanitation_solutions),
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
                modifier = Modifier
                    .padding(top = 180.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TipEmptyState()
            }
        }
    }
}