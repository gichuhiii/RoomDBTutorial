package com.example.busschedule.database.schedule

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Schedule {

    //setting the primary key
    @PrimaryKey val id: Int

    //column for stop name, we don't want a null value hence use of nonnull
    @NonNull @ColumnInfo(name = "stop_name") val stopName: String,

    //column for arrival time
    @NonNull @ColumnInfo(name = "arrival_time") val arrivalTime: Int,

    //we use keyword Entity so that room can recognize this class as something that can be used to define database tables
    //Room uses the class name as the db table by default which you can change by using @Entity(tableName = "schedule")
    //room queries are not case sensitive

    @Entity
    data class Schedule(
        @PrimaryKey val id: Int,
        @NonNull @ColumnInfo(name = "stop_name") val stopName: String,
        @NonNull @ColumnInfo(name = "arrival_time") val arrivalTime: Int
    )



}