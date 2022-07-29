package com.example.weather.data.schedule.factory

import com.example.weather.data.source.ScheduleEntityData
import com.example.weather.data.source.local.LocalScheduleEntityData
import com.example.weather.data.source.network.NetworkScheduleEntityData
import com.example.weather.util.Source
import javax.inject.Inject

class ScheduleFactory @Inject constructor(
    private val networkScheduleEntityData: NetworkScheduleEntityData,
    private val localScheduleEntityData: LocalScheduleEntityData
) {

    fun create(source: Source): ScheduleEntityData {
        return when (source) {
            Source.NETWORK -> networkScheduleEntityData
            else -> localScheduleEntityData
        }
    }
}