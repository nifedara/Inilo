package com.developerni.inilo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.util.iniloFontFamily

@Composable
fun QuickActionCard(name: Int, modifier: Modifier, color: Color, icon: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(100.dp)
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = stringResource(R.string.quick_action_card_icon),
                    tint = Color(0xFFfbf6ef)
                )
                Text(
                    text = stringResource(name),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFfbf6ef),
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}