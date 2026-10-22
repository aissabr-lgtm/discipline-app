package com.discipline.app.data

import android.content.Context
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DisciplineDao {
    @Query("SELECT * FROM habits WHERE isArchived = 0 ORDER BY createdAt ASC")
    fun getAllActiveHabits(): Flow<List<HabitEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: HabitEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateLog(log: DailyLogEntity)

    @Query("SELECT * FROM daily_logs WHERE date = :date")
    fun getLogsForDate(date: String): Flow<List<DailyLogEntity>>
}

@Database(entities = [HabitEntity::class, DailyLogEntity::class, DailyReflectionEntity::class], version = 1, exportSchema = false)
abstract class DisciplineDatabase : RoomDatabase() {
    abstract fun dao(): DisciplineDao

    companion object {
        @Volatile private var INSTANCE: DisciplineDatabase? = null

        fun getDatabase(context: Context): DisciplineDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DisciplineDatabase::class.java,
                    "discipline_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}