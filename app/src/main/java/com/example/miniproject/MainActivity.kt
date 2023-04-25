package com.example.miniproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import com.example.miniproject.common.Constant.API_KEY
import com.example.miniproject.common.Constant.API_KEY_MOVIE
import com.example.miniproject.common.Constant.BASE_URL
import com.example.miniproject.common.Constant.BASE_URL_MOVIE
import com.example.miniproject.common.Constant.RETURN_TYPE
import com.example.miniproject.data.*
import com.example.miniproject.data.model.DustResponse
import com.example.miniproject.ui.theme.MiniProjectTheme
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    //private val retrofit by lazy { retrofitBuilder() }
    private val retrofitMovie by lazy { movieRetrofit()}
    //private val dustService by lazy { retrofit.create(FineDustService::class.java)}
    private val movieService by lazy { retrofitMovie.create(TheMovieService::class.java)}

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            MiniProjectTheme(true) { 
                Scaffold() {
                    Column() {
                        Text(text = "안녕")
                    }
                }
            } 
        }

        movieServiceLoad()
    }

    private fun movieRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_MOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    private fun movieServiceLoad(){
        movieService.getTop(
            mapOf(
                "page" to "2",
                "api_key" to API_KEY_MOVIE,
                "sort_by" to "popularity.desc",
                "language" to "ko"
            )
        ).enqueue(object : Callback<MovieListResponse>{
            override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
                Log.d("로그코드", response.code().toString())
                Log.d("로그바디", response.body()?.results.toString())

                val MovieList = response.body()?.results?.map {
                    it.title
                    it.overview
                } 

            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                Log.d("실패", t.message.toString())
            }
        })
    }



//    var gson = GsonBuilder().setLenient().create()
//    private fun retrofitBuilder(): Retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create(gson))
//        .build()
//
//    private fun getDustData(): Unit {
//        val dustRoot: Call<DustResponse> = dustService.getFineDust(2022,"$RETURN_TYPE","$API_KEY")
//        dustRoot.enqueue(object: Callback<DustResponse> {
//
//                override fun onResponse(call: Call<DustResponse>, response: Response<DustResponse>) {
//
//                    Log.d("로그", response.body().toString())
//                }
//
//                override fun onFailure(call: Call<DustResponse>, t: Throwable) {
//                    Log.d("실패", t.message.toString())
//                }
//            })
//   }
}
