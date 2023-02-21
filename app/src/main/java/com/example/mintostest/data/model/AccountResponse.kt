package com.example.mintostest.data.model

import com.example.mintostest.data.repository.Repository
import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("response")
    val rsp:AccountData
   /* val bank: String,
    val beneficiaryBankAddress: String,
    val beneficiaryName: String,
    val currency: String,
    val iban: String,
    val paymentDetails: String,
    val swift: String*/
)