package com.example.mintostest.data.model

import javax.inject.Inject

data class AccountData @Inject constructor(
    val bank: String,
    val beneficiaryBankAddress: String,
    val beneficiaryName: String,
    val currency: String,
    val iban: String,
    val paymentDetails: String,
    val swift: String
)
