package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao

// use View model to separate the responsibility of loading data from your activity or fragmnet
//ViewModel is used to store data related to an app's UI and is also lifecycle aware

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    // method to get the full schedule
    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()

    //method to get the schedule for a specific stop
    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}