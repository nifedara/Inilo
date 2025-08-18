package com.example.inilo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inilo.R
import com.example.inilo.ui.component.util.iniloFontFamily

@Composable
fun TipEmptyState() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = stringResource(R.string.quick_action_card_icon),
            modifier = Modifier.padding(bottom = 10.dp).size(40.dp)
        )

        Text(
            text = stringResource(R.string.no_tips_yet),
            fontFamily = iniloFontFamily,
            modifier = Modifier.padding(bottom = 6.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(R.string.check_back_later),
            modifier = Modifier.padding(bottom = 6.dp),
            fontFamily = iniloFontFamily,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}