package com.example.mintostest.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mintostest.DI.DaggerApplicationComponent
import com.example.mintostest.R
import com.example.mintostest.data.model.AccountData
import com.example.mintostest.data.model.AccountResponse
import com.example.mintostest.data.repository.RepositoryImpl
import com.example.mintostest.data.repository.RepositoryImpl_Factory.create

import com.example.mintostest.databinding.ActivityMainBinding
import com.example.mintostest.utilities.Utility.background
import com.example.mintostest.utilities.Utility.isNetworkAvailable
import com.google.android.material.snackbar.Snackbar
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component = DaggerApplicationComponent.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        component.inject(this)
        initStaticTextViews(binding)

        viewModel.myResponse.observe(this, Observer { response ->
            handleApiResponse(response, binding)
        })

        fetchDataAndPopulateUI(binding)
    }

    private fun fetchDataAndPopulateUI(binding: ActivityMainBinding) {
        if (isNetworkAvailable(this)) {
            viewModel.fetchAccountData()
        } else {
            showSnackbar("No internet", binding)
        }
    }

    private fun handleApiResponse(response: Response<AccountResponse>, binding: ActivityMainBinding) {
        if (response.isSuccessful) {
            response.body()?.rsp?.let { data ->
                updateUI(binding, data)
            }
        } else {
            showSnackbar("REQUEST ERROR", binding)
        }
    }

    private fun updateUI(binding: ActivityMainBinding, data: AccountData) {
        with(binding) {
            CurrencyTick.text = data.currency
            IBANBlock.info.text = data.iban
            SwiftBlock.info.text = data.swift
            BeneficiaryBlock.info.text = data.beneficiaryName
            BeneficiaryAddressBlock.info.text = data.beneficiaryBankAddress
            investorId.info.text = data.paymentDetails
        }
    }

    private fun showSnackbar(text: String, binding: ActivityMainBinding) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .background(ContextCompat.getColor(this, R.color.red))
            .show()
    }

    private fun initStaticTextViews(binding: ActivityMainBinding) {
        with(binding) {
            IBANBlock.header.text = getString(R.string.iban_header)
            SwiftBlock.header.text = getString(R.string.swift_header)
            BeneficiaryBlock.header.text = getString(R.string.beneficiary_name_header)
            BeneficiaryAddressBlock.header.text = getString(R.string.bank_address_header)
            investorId.header.text = getString(R.string.investor_id_header)
        }
    }
}

