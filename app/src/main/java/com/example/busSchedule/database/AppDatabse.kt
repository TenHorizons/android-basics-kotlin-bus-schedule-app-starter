package com.example.busSchedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busSchedule.database.schedule.Schedule
import com.example.busSchedule.database.schedule.ScheduleDao

@Database(entities = arrayOf(Schedule::class), version =1)
abstract class AppDatabse: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabse? = null

        fun getDatabase(context: Context): AppDatabse {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabse::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}