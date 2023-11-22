package com.maverick.dynamicformdemo

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    val api: FormApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8055")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(FormApiService::class.java)
    }
}