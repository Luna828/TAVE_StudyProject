package com.example.miniproject.data

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path

const val API_KEY = "vsQr1KeLnsjadiZfCsU4VzNbdn6pfRIK%2Bfb4hOtDici544hPLxQxu0uFL11j9KcN7sp09ch%2FD5goEt13BQHCCA%3D%3D"
const val BASE_URL = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc"

//HTTP CRUD 메서드를 정의해 둔 인터페이스
interface FineDustService {
    @GET("getUlfptcaAlarmInfo?{year}&{pageNo}&{numOfRows}&{returnType}&{serviceKey}")
    suspend fun getFineDust(
        @Path("year")
        year: Int,
        @Path("pageNo")
        pageNo: Int,
        @Path("numOfRows")
        numOfRows: Int,
        @Path("returnType")
        returnType: String,
        @Path("serviceKey")
        serviceKey: String
    ): List<FineDustBody>
}