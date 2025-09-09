package com.developerni.inilo.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.QuickActionCard
import com.developerni.inilo.ui.component.SolutionScreenType
import com.developerni.inilo.ui.component.SolutionsCard
import com.developerni.inilo.ui.component.util.cardColors
import com.developerni.inilo.ui.component.util.cardIconSizes
import com.developerni.inilo.ui.component.util.cardIcons
import com.developerni.inilo.ui.component.util.groupedSolutions
import com.developerni.inilo.ui.component.util.iniloFontFamily
import com.developerni.inilo.ui.component.util.toScreenType
import com.developerni.inilo.ui.viewModel.LoginStateViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandingScreen(
    onSolutionClick: (SolutionScreenType) -> Unit,
    loginStateViewModel: LoginStateViewModel
) {

    val isLoggedIn = loginStateViewModel.isLoggedIn.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFfbf6ef))
            .padding(top = 60.dp)
    ) {
        if (isLoggedIn.value) {
            stickyHeader {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.padding(start = 12.dp)
                        .background(Color(0xFFfbf6ef))
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .border(
                                    width = 2.dp,
                                    shape = CircleShape,
                                    color = Color(0xFF9168f5)
                                )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.profile),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xFF9168f5)
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Welcome",
                            fontFamily = iniloFontFamily,
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 10.dp),
                            color = Color(0xFF3b1d38)
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                }
                Divider(
                    color = Color(0xffede9e3),
                    thickness = 6.dp
                )
            }
        }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 24.dp, end = 24.dp)
            ) {
                if (!isLoggedIn.value) {
                    Text(
                        text = stringResource(R.string.welcome_to),
                        fontFamily = iniloFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.app_name),
                    fontFamily = iniloFontFamily,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = Color(0xFF3b1d38)
                )
                Text(
                    text = stringResource(R.string.improvise_for_your_daily_needs),
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    color = Color(0xFF3b1d38),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = stringResource(R.string.basic_needs_enumerated),
                    textAlign = TextAlign.Center,
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color(0xFF3b1d38),
                    modifier = Modifier.padding(bottom = 22.dp)
                )
            }
        }

        stickyHeader {
            Divider(
                color = Color(0xffede9e3),
                thickness = 8.dp
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFfbf6ef)),
                shape = RoundedCornerShape(0)
            ) {
                Text(
                    text = stringResource(R.string.quick_actions),
                    fontSize = 21.sp,
                    fontFamily = iniloFontFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 10.dp),
                    color = Color(0xFF3b1d38)
                )
            }
        }

        item {
            Column(modifier = Modifier.background(Color(0xFFfbf6ef))) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, bottom = 16.dp, top = 8.dp)
                ) {
                    QuickActionCard(
                        name = R.string.practice_cards, modifier = Modifier.weight(0.5f),
                        //color = Color(0xFF02bc59),
                        color = Color(0xFF9168f5),
                        icon = R.drawable.quiz
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    QuickActionCard(
                        name = R.string.safety_check, modifier = Modifier.weight(0.5f),
                        color = Color(0xFF9168f5),
                        //color = Color(0xFF02bc59),
                        icon = R.drawable.safety_check
                    )
                }
            }
        }

        stickyHeader {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFfbf6ef)),
                shape = RoundedCornerShape(0)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.explore_solutions),
                        fontFamily = iniloFontFamily,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 20.dp, bottom = 10.dp, start = 24.dp),
                        color = Color(0xFF3b1d38)
                    )
                }
            }
        }

        itemsIndexed(groupedSolutions) { index, solution ->
            Column(modifier = Modifier.background(Color(0xFFfbf6ef))) {
                SolutionsCard(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                    title = solution.stringResId,
                    onClick = { onSolutionClick(solution.toScreenType()) },
                    color = cardColors[index],
                    icons = cardIcons[index],
                    iconSize = cardIconSizes[index],
                    iconColor = Color(0xFFfbf6ef)
                )
                if (index == groupedSolutions.lastIndex) {
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }
}