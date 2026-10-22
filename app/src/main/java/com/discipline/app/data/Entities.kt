package com.discipline.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey val id: String,
    val name: String,
    val category: String,
    val type: String, // "yesno" or "measurable"
    val target: Int = 1,
    val unit: String = "",
    val schedule: String = "daily",
    val reminderTime: String? = null,
    val isArchived: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "daily_logs", primaryKeys = ["date", "habitId"])
data class DailyLogEntity(
    val date: String,
    val habitId: String,
    val completed: Boolean = false,
    val value: Int = 0
)

@Entity(tableName = "daily_reflections")
data class DailyReflectionEntity(
    @PrimaryKey val date: String,
    val reflection: String
)