package com.example.busSchedule.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busSchedule.database.schedule.Schedule
import com.example.busSchedule.database.schedule.ScheduleDao

/**Not sure if this class should be private.
 * If fragment/activity is not meant to access this class directly
 * Because ViewModel is meant to handle lifecycle events, and
 * fragment/activity accesses ViewModel through Factory,
 * There seems to be no reason to have this class as public.*/
private class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {
    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()

    fun scheduleForStopName(name:String):List<Schedule> = scheduleDao.getByStopName(name)
}

class BudScheduleViewModelFactory(private val scheduleDao: ScheduleDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}