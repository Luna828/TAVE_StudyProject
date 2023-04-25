package com.example.miniproject.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap



interface TheMovieService {
    @GET("discover/movie")
    fun getTop(@QueryMap par: Map<String, String>): Call<MovieListResponse>
}