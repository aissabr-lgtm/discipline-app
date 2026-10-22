package com.discipline.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(currentTheme: String, onThemeChanged: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Appearance", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { onThemeChanged("light") }) { Text("Light") }
            Button(onClick = { onThemeChanged("dark") }) { Text("Dark") }
            Button(onClick = { onThemeChanged("system") }) { Text("System") }
        }
    }
}