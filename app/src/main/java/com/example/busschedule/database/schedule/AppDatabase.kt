package com.example.busschedule.database.schedule

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao

    //ensures only one instance of the database exists, the instance is stored in the companion object
    companion object {

        //Volatile is used to avoid potential bugs
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            //return instance of db if it exists or create database if needed
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                        //to load existing data
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance
                instance

            }
        }
    }

}