package com.developerni.inilo.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.util.iniloFontFamily

@Composable
fun TipCard() {
    ElevatedCard(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 12.dp),
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row {
                Card(
                    shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Magenta)
                ) {
                    Text(
                        text = stringResource(R.string.easy),
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp),
                        fontFamily = iniloFontFamily,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "08/08/25",
                    fontFamily = iniloFontFamily,
                )
            }

            Text(
                text = "Personal Safety Awareness",
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                fontFamily = iniloFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Develop situational awareness to stay safe in unfamiliar places",
                fontFamily = iniloFontFamily,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row {
                Row {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = stringResource(R.string.quick_action_card_icon),
                    )
                    Text(
                        text = "1 material",
                        fontFamily = iniloFontFamily,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Row {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = stringResource(R.string.quick_action_card_icon),
                    )
                    Text(
                        text = "5 steps",
                        fontFamily = iniloFontFamily,
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Card(
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(
                        text = "awareness",
                        fontFamily = iniloFontFamily,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        color = Color.Gray
                    )
                }
            }
        }
    }
}