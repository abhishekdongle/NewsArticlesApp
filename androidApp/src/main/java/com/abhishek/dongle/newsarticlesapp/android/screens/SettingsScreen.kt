package com.abhishek.dongle.newsarticlesapp.android.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Text(
        text = "Accounts",
        style = TextStyle(fontWeight = FontWeight.Medium)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "Notifications",
        style = TextStyle(fontWeight = FontWeight.Medium)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "About",
        style = TextStyle(fontWeight = FontWeight.Medium)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "Help",
        style = TextStyle(fontWeight = FontWeight.Medium)
    )
    Spacer(modifier = Modifier.height(4.dp))
}