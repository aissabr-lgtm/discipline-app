package com.discipline.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodayScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Today's Execution", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Daily Score: 80%", style = MaterialTheme.typography.titleLarge)
                Text("4 of 5 habits completed", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}