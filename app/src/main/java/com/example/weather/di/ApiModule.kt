package com.example.weather.di

import com.example.weather.data.schedule.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun providePrayApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

}