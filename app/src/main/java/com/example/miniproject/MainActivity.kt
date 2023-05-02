package com.example.miniproject

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miniproject.common.Constant.API_KEY_MOVIE
import com.example.miniproject.data.*
import com.example.miniproject.service.TheMovieService
import com.example.miniproject.ui.theme.MiniProjectTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val nameList = remember { mutableStateListOf<String>() }
            movieServiceLoad(nameList, applicationContext)

            MiniProjectTheme(true) {
                Scaffold() {
                    Text(
                        text = "현재 영화 TOP20",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(15.dp, 15.dp, 15.dp, 20.dp)
                    )
                    LazyColumn(modifier = Modifier.padding(0.dp, 45.dp)) {
                        items(nameList) { movie ->
                            MovieCard(name = movie)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun MovieCard(name: String) {
        Card(
            Modifier
                .padding(12.dp)
                .border(width = 1.dp, color = Color.White)
                .height(300.dp)
                .fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
            ) {
                Text("$name")
            }
        }
    }
}

private fun movieServiceLoad(nameList: MutableList<String>, ctx: Context) {
    val movieRetrofit = RetrofitClient.movieRetrofit
    movieRetrofit.create(TheMovieService::class.java).getQuery(
        nameList.toString(),
        API_KEY_MOVIE,
        "popularity.desc",
        "ko"
    ).enqueue(object : Callback<MovieListResponse> {
        override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
            if (response.isSuccessful) {
                response.body()?.results?.map {
                    nameList.add("${it.title}" + "\n\n${it.overview}")
                }
            }
        }

        override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
            Log.d("실패", t.message.toString())
        }
    })
}

