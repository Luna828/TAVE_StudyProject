package com.example.miniproject.data.model.items.body

import com.google.gson.annotations.SerializedName

data class DustBody(
    @SerializedName("clearVal")
    val clearVal: String,
    @SerializedName("sn")
    val sn: String,
    @SerializedName("districtName")
    val districtName: String,
    @SerializedName("dataDate")
    val dataDate: String,
    @SerializedName("issueVal")
    val issueVal: String,
    @SerializedName("issueTime")
    val issueTime: String,
    @SerializedName("clearDate")
    val clearDate: String,
    @SerializedName("issueDate")
    val issueDate: String,
    @SerializedName("moveName")
    val moveName: String,
    @SerializedName("clearTime")
    val clearTime: String,
    @SerializedName("issueGbn")
    val issueGbn: String,
    @SerializedName("itemCode")
    val itemCode: String,
)
