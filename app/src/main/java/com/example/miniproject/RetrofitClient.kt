package com.example.miniproject

import com.example.miniproject.common.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

     val movieRetrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL_MOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}