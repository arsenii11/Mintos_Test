package com.example.mintostest.domain

import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("response")
    val rsp:AccountData
)