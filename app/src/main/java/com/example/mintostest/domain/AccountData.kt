package com.example.mintostest.domain

data class AccountData(
    val bank: String,
    val beneficiaryBankAddress: String,
    val beneficiaryName: String,
    val currency: String,
    val iban: String,
    val paymentDetails: String,
    val swift: String
)
