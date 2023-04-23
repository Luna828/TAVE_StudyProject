package com.example.miniproject.data.model

import com.example.miniproject.data.model.items.body.DustBody
import com.google.gson.annotations.SerializedName

data class DustItems(
    @SerializedName("items")
    val items: List<DustBody>
)