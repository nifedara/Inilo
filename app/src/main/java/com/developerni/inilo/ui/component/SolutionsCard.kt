package com.developerni.inilo.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.util.iniloFontFamily

@Composable
fun SolutionsCard(modifier: Modifier,
                  title: Int,
                  onClick: () -> Unit,
                  color: Color,
                  icons: Int,
                  iconSize: Dp = 32.dp,
                  iconColor: Color
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.padding(bottom = 16.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFfbf6ef)),
        border = BorderStroke(2.dp, color)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(180.dp)
            ) {

                Card(
                    shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(containerColor = color)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(icons),
                            modifier = Modifier.size(iconSize),
                            contentDescription = stringResource(R.string.quick_action_card_icon),
                            tint = iconColor
                        )
                    }
                }
                Text(
                    text = stringResource(title),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = stringResource(R.string.tips_available),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 16.sp,
                    color = Color.Black.copy(0.7f)
                )
            }
        }
    }
}