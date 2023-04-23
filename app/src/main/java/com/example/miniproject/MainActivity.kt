package com.example.miniproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.miniproject.common.Constant.API_KEY
import com.example.miniproject.common.Constant.BASE_URL
import com.example.miniproject.data.FineDustService
import com.example.miniproject.data.model.DustItems
import com.example.miniproject.data.model.DustRoot
import com.example.miniproject.data.model.items.body.DustBody
import com.example.miniproject.ui.theme.MiniProjectTheme
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private val retrofit by lazy { retrofitBuilder() }
    private val dustService by lazy { retrofit.create(FineDustService::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MiniProjectTheme(true) {} }

        getDustData()
    }


    private fun retrofitBuilder(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getDustData(): Unit = dustService.getFineDust(2023,"$API_KEY")
        .enqueue(object: Callback<DustBody> {
            override fun onResponse(call: Call<DustBody>, response: Response<DustBody>) {
                Log.d("성공", response.code().toString())
                Log.d("성공", response.body()?.districtName.toString())
            }

            override fun onFailure(call: Call<DustBody>, t: Throwable) {
                Log.d("실패", t.message.toString())
            }
        })
}
