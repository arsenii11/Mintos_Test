package com.example.mintostest.data

import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("response")
    val rsp: AccountData
)