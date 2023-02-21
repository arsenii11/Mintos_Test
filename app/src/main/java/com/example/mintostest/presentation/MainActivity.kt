package com.example.mintostest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mintostest.data.repository.Repository

import com.example.mintostest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /*@Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this,  viewModelFactory)[MainViewModel::class.java ]
    }*/

    /*@Inject
    lateinit var viewModel:MainViewModel*/

    /* private val component by lazy {
         (application as ExampleApp).component
     }*/

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initStaticTextViews(binding)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getAccountData()



        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("response_test", response.toString())
            binding.IBANBlock.info.text = response.rsp.iban
            binding.SwiftBlock.info.text = response.rsp.swift
            binding.BeneficiaryBlock.info.text = response.rsp.beneficiaryName
            binding.BeneficiaryAddressBlock.info.text = response.rsp.beneficiaryBankAddress
            binding.investorId.info.text = response.rsp.paymentDetails
        })


    }

    //Because I'm using a view templates in layout I've to fill TextViews in code
    private fun initStaticTextViews(binding: ActivityMainBinding) {
        binding.IBANBlock.header.text = "Beneficiary bank account number / IBAN"
        binding.SwiftBlock.header.text = "Beneficiary bank SWIFT / BIC code"
        binding.BeneficiaryBlock.header.text = "Beneficiary name"
        binding.BeneficiaryAddressBlock.header.text = "Beneficiary bank address"
        binding.investorId.header.text = "Add this information to payment details"
    }

}