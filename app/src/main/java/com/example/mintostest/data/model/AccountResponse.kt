package com.example.mintostest.data.model

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class AccountResponse @Inject constructor(
    @SerializedName("response")
    val rsp: AccountData
)