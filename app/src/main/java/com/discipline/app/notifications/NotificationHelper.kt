package com.discipline.app.notifications

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

class ReminderWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return Result.success()
    }
}

object NotificationScheduler {
    fun scheduleHabitReminder(context: Context, habitId: String, habitName: String, delayMinutes: Long) {
        val request = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setInitialDelay(delayMinutes, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(context).enqueue(request)
    }
}