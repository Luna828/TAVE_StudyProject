package com.example.miniproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.miniproject.data.BASE_URL
import com.example.miniproject.data.FineDustBody
import com.example.miniproject.data.FineDustService
import com.example.miniproject.ui.theme.MiniProjectTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fun getJSONData(courseList: MutableList<String>, ctx: Context){
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            
            val fineDustService = retrofit.create(FineDustService::class.java)
            
            val call: List<FineDustBody> = fineDustService.getFineDust(2023)
            
            fineDustService
                .getFineDust(2022)
                .enqueque(object: Callback<FineDustBody>{
                    override fun onResponse(call: Call<FineDustBody>, response: Response<FineDustBody>) {
                        if(response.isSuccessful){

                        }
                    }

                    override fun onFailure(call: Call<FineDustBody>, t: Throwable) {
                        Log.d("로그", t.message.toString())
                    }
                })

            setContent {
                MiniProjectTheme(true) {

                }
            }
            
        }
        
        

        CoroutineScope(Dispatchers.Main).launch{

        }
    }
}