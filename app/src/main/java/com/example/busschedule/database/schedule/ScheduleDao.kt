package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    //show all bus stops in ascending order by arrival time
    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    //use flow to allow DAO to continuously emit data from the database and send it back to the fragment
    fun getAll(): Flow<List<Schedule>>

    //select all columns where results match selected stop name in the schedule table
    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getByStopName(stopName: String): Flow<List<Schedule>>

}