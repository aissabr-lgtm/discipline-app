package com.discipline.app.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF10B981),
    background = Color(0xFF090D16),
    surface = Color(0xFF111827)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF059669),
    background = Color(0xFFF9FAFB),
    surface = Color(0xFFFFFFFF)
)

@Composable
fun DisciplineTheme(darkTheme: Boolean, content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(colorScheme = colorScheme, content = content)
}