package com.example.inilo.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.inilo.ui.component.QuickActionCard
import com.example.inilo.ui.component.SolutionScreenType
import com.example.inilo.ui.component.SolutionsCard
import com.example.inilo.ui.component.util.cardColors
import com.example.inilo.ui.component.util.cardIconSizes
import com.example.inilo.ui.component.util.cardIcons
import com.example.inilo.ui.component.util.groupedSolutions
import com.example.inilo.ui.component.util.iniloFontFamily
import com.example.inilo.ui.component.util.toScreenType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandingScreen(
    onSolutionClick: (SolutionScreenType) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))
            .padding(top = 60.dp)
    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 24.dp, end = 24.dp)
            ) {
                Text(
                    text = stringResource(R.string.welcome_to),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = stringResource(R.string.app_name),
                    fontFamily = iniloFontFamily,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = stringResource(R.string.improvise_for_your_daily_needs),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp,
                    color = Color(0xFF2A628F),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = stringResource(R.string.basic_needs_enumerated),
                    textAlign = TextAlign.Center,
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    color = Color(0xFF2A628F),
                    modifier = Modifier.padding(bottom = 22.dp)
                )
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F5F5)),
                shape = RoundedCornerShape(0)
            ) {
                Text(
                    text = stringResource(R.string.quick_actions),
                    fontSize = 22.5.sp,
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 10.dp)
                )
            }
        }

        item {
            Column(modifier = Modifier.background(Color(0xFFF6F5F5))) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, bottom = 16.dp, top = 8.dp)
                ) {
                    QuickActionCard(
                        name = R.string.scan_food, modifier = Modifier.weight(0.5f),
                        color = Color(0xFFE8EBED)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    QuickActionCard(
                        name = R.string.safety_check, modifier = Modifier.weight(0.5f),
                        color = Color(0xFFE8EBED)
                    )
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F5F5)),
                shape = RoundedCornerShape(0)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.explore_solutions),
                        fontFamily = iniloFontFamily,
                        fontSize = 22.5.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 20.dp, bottom = 10.dp, start = 24.dp)
                    )
                }
            }
        }

        itemsIndexed(groupedSolutions) { index, solution ->
            Column(modifier = Modifier.background(Color(0xFFF6F5F5))) {
                SolutionsCard(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                    title = solution.stringResId,
                    onClick = { onSolutionClick(solution.toScreenType()) },
                    color = cardColors[index],
                    icons = cardIcons[index],
                    iconSize = cardIconSizes[index]
                )
                if (index == groupedSolutions.lastIndex) {
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }
}