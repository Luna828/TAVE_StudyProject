package com.example.miniproject

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.miniproject.common.Constant.API_KEY_MOVIE
import com.example.miniproject.common.Constant.BASE_URL_MOVIE
import com.example.miniproject.data.*
import com.example.miniproject.service.TheMovieService
import com.example.miniproject.ui.theme.MiniProjectTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    // private val retrofit by lazy { retrofitBuilder() }
    //private val dustService by lazy { retrofit.create(FineDustService::class.java) }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val courseList = remember { mutableStateListOf<String>() }
            movieServiceLoad(courseList, applicationContext)

            MiniProjectTheme(true) {
                Scaffold() {
                    LazyColumn {
                        items(courseList) { movie ->
                            MovieCard(orden = movie)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun MovieCard(orden: String) {
        Card(
            Modifier
                .padding(12.dp)
                .border(width = 1.dp, color = Color.White)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("$orden")
            }
        }
    }
    private fun movieServiceLoad(courseList: MutableList<String>, ctx: Context) {
        val movieRetrofit = RetrofitClient.movieRetrofit
        movieRetrofit.create(TheMovieService::class.java).getQuery(
            courseList.toString(),
            API_KEY_MOVIE,
            "popularity.desc",
            "ko"
        ).enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
                if (response.isSuccessful) {
                    response.body()?.results?.map {
                        it.title
                        it.release_date
                        courseList.add(it.title)
                    }
                }
            }
            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                Log.d("실패", t.message.toString())
            }
        })
    }

//
//    var gson = GsonBuilder().setLenient().create()
//    private fun retrofitBuilder(): Retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create(gson))
//        .build()
//
//    private fun getDustData(): Unit {
//        val dustRoot: Call<DustResponse> = dustService.getFineDust(2022, "$RETURN_TYPE", "$API_KEY")
//        dustRoot.enqueue(object : Callback<DustResponse> {
//
//            override fun onResponse(call: Call<DustResponse>, response: Response<DustResponse>) {
//
//                Log.d("로그", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<DustResponse>, t: Throwable) {
//                Log.d("실패", t.message.toString())
//            }
//        })
//    }
}
