package com.example.weather.di

import com.example.weather.data.schedule.repository.ScheduleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.example.weather.dimain.ScheduleRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class ScheduleModule {

    @Binds
    abstract fun bindScheduleRepository(scheduleRepositoryImpl: ScheduleRepositoryImpl): ScheduleRepository
}