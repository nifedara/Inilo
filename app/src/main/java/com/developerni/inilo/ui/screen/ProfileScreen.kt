package com.developerni.inilo.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.IniloScaffold
import com.developerni.inilo.ui.component.util.iniloFontFamily
import com.developerni.inilo.ui.viewModel.LoginStateViewModel

enum class ProfileScreenNavigation {
    Back, Logout, EditQuickActionsTab
}
@Composable
fun ProfileScreen(
    onRoute: (ProfileScreenNavigation) -> Unit,
    loginStateViewModel: LoginStateViewModel
) {
    val barColor = Color(0xFFfbf6ef)
    val textColor = Color(0xFF3b1d38)

    IniloScaffold(
        onBack = { onRoute(ProfileScreenNavigation.Back) },
        pageTitle = "Profile",
        appBarColor = barColor
    ) {
        Column {
            Divider(
                color = Color(0xffede9e3),
                thickness = 8.dp
            )

            Column(
                modifier = Modifier.background(barColor)
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFF9168f5)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable{ onRoute(ProfileScreenNavigation.Logout) }
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = stringResource(R.string.logout),
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp),
                            fontWeight = FontWeight.Normal,
                            fontFamily = iniloFontFamily,
                            fontSize = 14.sp,
                            color = textColor
                        )
                    }
                }
            }
        }
    }
}