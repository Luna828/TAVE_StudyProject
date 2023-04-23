package com.example.miniproject.data

import android.telecom.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "vsQr1KeLnsjadiZfCsU4VzNbdn6pfRIK%2Bfb4hOtDici544hPLxQxu0uFL11j9KcN7sp09ch%2FD5goEt13BQHCCA%3D%3D"
const val BASE_URL = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/"

//HTTP CRUD 메서드를 정의해 둔 인터페이스
interface FineDustService {
    @GET("getUlfptcaAlarmInfo/?year={year}&serviceKey=$API_KEY")
    fun getFineDust(
        @Path("year")
        year: Int,
    ): Call<FineDustBody>

}
