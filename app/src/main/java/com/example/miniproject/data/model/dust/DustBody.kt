package com.example.miniproject.data.model

import com.example.miniproject.data.model.dust.body.DustItem
import com.google.gson.annotations.SerializedName

data class DustBody(
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("items")
    val items: List<DustItem>
)