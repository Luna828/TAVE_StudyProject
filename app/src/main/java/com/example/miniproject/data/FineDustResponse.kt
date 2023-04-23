package com.example.miniproject.data

import com.google.gson.annotations.SerializedName

data class FineDustList(
    @SerializedName("response") val list: FineDustResponse
)

data class FineDustResponse(
    @SerializedName("items") val items: List<FineDustBody>
)

data class FineDustBody(
    @SerializedName("clearVal") val clearVal: String,
    @SerializedName("sn") val sn: String,
    @SerializedName("districtName") val districtName: String,
    @SerializedName("dataDate") val dataDate: String,
    @SerializedName("issueVal") val issueVal: String,
    @SerializedName("issueTime") val issueTime: String,
    @SerializedName("clearDate") val clearDate: String,
    @SerializedName("issueDate") val issueDate: String,
    @SerializedName("moveName") val moveName: String,
    @SerializedName("clearTime") val clearTime: String,
    @SerializedName("issueGbn") val issueGbn: String,
    @SerializedName("itemCode") val itemCode: String,
)

data class FineDustBody1(
    val clearVal: String,
    val sn: String,
    val districtName: String,
    val dataDate: String,
    val issueVal: String,
    val issueTime: String,
    val clearDate: String,
    val moveName: String,
    val issueDate: String,
    val clearTime: String,
    val issueGbn: String,
    val itemCode: String,
)