package com.example.miniproject.data.model

import com.google.gson.annotations.SerializedName
import retrofit2.Response

data class DustRoot(
    @SerializedName("response")
    val response: DustResponse
)

data class DustResponse(
    @SerializedName("body")
    val body: DustBody,
)

