package com.example.inilo.ui.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.inilo.ui.component.Solutions
import com.example.inilo.ui.component.SolutionsCard
import com.example.inilo.ui.component.toScreenType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandingScreen(
    onSolutionClick: (SolutionScreenType) -> Unit
) {
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 78.dp, start = 24.dp, end = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.welcome_to),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = stringResource(R.string.improvise_for_your_daily_needs),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = stringResource(R.string.basic_needs_enumerated),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.quick_actions),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                QuickActionCard(name = R.string.scan_food, modifier = Modifier.weight(0.5f))
                Spacer(modifier = Modifier.width(12.dp))
                QuickActionCard(name = R.string.safety_check, modifier = Modifier.weight(0.5f))
            }
            Spacer(modifier = Modifier.padding(bottom = 10.dp))



            val groupedSolutions = listOf (
                    Solutions.Education,
                    Solutions.Water,
                    Solutions.Power,
                    Solutions.HealthAndSanitation,
                    Solutions.Food,
                    Solutions.SafetyAndSecurity
            )

            LazyColumn {
                stickyHeader {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(0)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = stringResource(R.string.explore_solutions),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
                            )
                        }
                    }
                }
                itemsIndexed(groupedSolutions) { index, solution ->
                    SolutionsCard(
                        modifier = Modifier.fillMaxWidth(),
                        title = solution.stringResId,
                        onClick = { onSolutionClick(solution.toScreenType()) }
                    )

                    Log.v("App Navigation", "${solution.toScreenType()}")
                    if (index == groupedSolutions.lastIndex) {
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
        }
    }
}