package com.example.miniproject.service

import com.example.miniproject.data.model.DustResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//HTTP CRUD 메서드를 정의해 둔 인터페이스
interface FineDustService {
    @GET("getUlfptcaAlarmInfo")
    fun getFineDust(
        @Query("year")
        year: Int,
        @Query("returnType")
        returnType: String,
        @Query("serviceKey")
        serviceKey: String
    ): Call<DustResponse>
}

