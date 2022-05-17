package com.example.busSchedule

import android.app.Application
import com.example.busSchedule.database.AppDatabse

class BusScheduleApplication: Application(){
    val database: AppDatabse by lazy { AppDatabse.getDatabase(this)}
}