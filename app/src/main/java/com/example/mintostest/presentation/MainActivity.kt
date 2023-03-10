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
import com.example.mintostest.data.repository.RepositoryImpl
import com.example.mintostest.data.repository.RepositoryImpl_Factory.create

import com.example.mintostest.databinding.ActivityMainBinding
import com.example.mintostest.utilities.Utility.background
import com.example.mintostest.utilities.Utility.isNetworkAvailable
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MainActivity : AppCompatActivity() {



    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this,  viewModelFactory)[MainViewModel::class.java ]
    }


    private val component = DaggerApplicationComponent.create()




    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initStaticTextViews(binding)



        if (isNetworkAvailable(this)){
        viewModel.getAccountData()



        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){

            Log.d("response_test", response.toString())
            binding.CurrencyTick.text = response.body()?.rsp?.currency
            binding.IBANBlock.info.text = response.body()?.rsp?.iban
            binding.SwiftBlock.info.text = response.body()?.rsp?.swift
            binding.BeneficiaryBlock.info.text = response.body()?.rsp?.beneficiaryName
            binding.BeneficiaryAddressBlock.info.text = response.body()?.rsp?.beneficiaryBankAddress
            binding.investorId.info.text = response.body()?.rsp?.paymentDetails
            }
            else {
                    showSnackbar("REQUEST ERROR", binding)
            }
        })
        }
        else showSnackbar("No internet", binding)


    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun showSnackbar(text: String, binding: ActivityMainBinding) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .background(ContextCompat.getColor(this!!, R.color.red))
            .show()
    }

    //Because I'm using a view templates in layout I've to fill TextViews in code
    private fun initStaticTextViews(binding: ActivityMainBinding) {
        binding.IBANBlock.header.text = R.string.iban_header.toString()
        binding.SwiftBlock.header.text = R.string.swift_header.toString()
        binding.BeneficiaryBlock.header.text = R.string.beneficiary_name_header.toString()
        binding.BeneficiaryAddressBlock.header.text = R.string.bank_address_header.toString()
        binding.investorId.header.text = R.string.investor_id_header.toString()
    }

}