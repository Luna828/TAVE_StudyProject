package com.example.miniproject.data

data class FineDustResponse(
    val totalCount: Int,
    val items: List<FineDustBody>
)

data class FineDustBody(
    val clearVal: String,
    val sn: String,
    val districtName: String,
    val dataDate: String,
    val issueVal: String,
    val issueTime: String,
    val clearDate: String,
    val issueDate: String,
    val moveName: String,
    val clearTime: String,
    val issueGbn: String,
    val itemCode: String,
)