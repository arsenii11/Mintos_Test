package com.example.mintostest.data.model

data class AccountData(
    val bank: String,
    val beneficiaryBankAddress: String,
    val beneficiaryName: String,
    val currency: String,
    val iban: String,
    val paymentDetails: String,
    val swift: String
)
