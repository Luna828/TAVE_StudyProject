package com.example.miniproject.data.model

import com.google.gson.annotations.SerializedName
import retrofit2.Response

//data class DustRoot(
//
//)

data class DustResponse(
    @SerializedName("response")
    val response: DustResponse,
    @SerializedName("body")
    val body: DustBody,
)

