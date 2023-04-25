package com.example.miniproject.service

import com.example.miniproject.data.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap



interface TheMovieService {
    @GET("discover/movie")
    fun getTop(@QueryMap par: Map<String, String>): Call<MovieListResponse>

    @GET("discover/movie")
    fun getQuery(
        @Query("page")
        page: String,
        @Query("api_key")
        api_key: String,
        @Query("sort_by")
        sort_by: String,
        @Query("language")
        language: String
    ): Call<MovieListResponse>
}