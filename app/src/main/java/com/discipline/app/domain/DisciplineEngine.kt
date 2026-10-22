package com.discipline.app.domain

import androidx.compose.ui.graphics.Color
import com.discipline.app.data.HabitEntity
import com.discipline.app.data.DailyLogEntity

object DisciplineEngine {
    
    fun calculateDailyScore(habits: List<HabitEntity>, logs: List<DailyLogEntity>): Double? {
        if (habits.isEmpty()) return null
        
        val completedCount = logs.count { it.completed }
        return (completedCount.toDouble() / habits.size.toDouble()) * 100.0
    }

    fun getScoreColor(score: Double?): Color {
        if (score == null) return Color(0xFF6B7280) // Gray for no scheduled habits
        return when (score.toInt()) {
            100 -> Color(0xFF064E3B)      // Emerald
            in 80..99 -> Color(0xFF10B981) // Green
            in 60..79 -> Color(0xFF84CC16) // Lime
            in 40..59 -> Color(0xFFF59E0B) // Amber
            in 20..39 -> Color(0xFFF97316) // Orange
            in 1..19 -> Color(0xFFEF4444)  // Red
            else -> Color(0xFF7F1D1D)      // Dark Red (0%)
        }
    }
}