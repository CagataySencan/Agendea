package com.cagataysencan.agendea.apiService

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object retrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nomics.com/v1/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val api : cryptoApiService by lazy {
        retrofit.create(cryptoApiService::class.java)
    }
}