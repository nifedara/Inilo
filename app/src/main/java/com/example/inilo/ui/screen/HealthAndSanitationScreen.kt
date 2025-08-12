package com.example.inilo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inilo.R
import com.example.inilo.ui.component.IniloScaffold

@Composable
fun HealthAndSanitationScreen(
    onBack: () -> Unit
) {
    IniloScaffold(
        onBack = { onBack() },
        pageTitle = "",
        appBarColor = Color(0xFF1A91FF)
    ) {
        Column(
            modifier = Modifier.background(Color(0xFF1A91FF))
                .fillMaxWidth()
                .padding(top = 0.dp, start = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
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
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = stringResource(R.string.quick_action_card_icon),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Text (
                text = stringResource(R.string.health_and_sanitation),
                modifier = Modifier.padding(bottom = 4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text (
                text = stringResource(R.string.hygiene_practices_and_sanitation_solutions),
                modifier = Modifier.padding(bottom = 6.dp),
                textAlign = TextAlign.Center
            )
            Text (
                text = stringResource(R.string.tips_available),
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}