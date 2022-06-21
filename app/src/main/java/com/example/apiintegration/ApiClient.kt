package com.example.apiintegration

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun getRetrofitClient(): Retrofit {
        val gson= GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl("https://www.breakingbadapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}