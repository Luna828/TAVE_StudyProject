package com.example.miniproject.data.model

import com.google.gson.annotations.SerializedName

data class DustRoot(
    @SerializedName("response")
    val response: DustRootBody
)

data class DustRootBody(
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("body")
    val body: DustItems
)
