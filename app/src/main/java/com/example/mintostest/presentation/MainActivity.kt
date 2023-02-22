package com.example.mintostest.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mintostest.R
import com.example.mintostest.data.repository.RepositoryImpl

import com.example.mintostest.databinding.ActivityMainBinding
import com.example.mintostest.domain.DataUseCase
import com.example.mintostest.utilities.Utility.background
import com.example.mintostest.utilities.Utility.isNetworkAvailable
import com.google.android.material.snackbar.Snackbar

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

        val repository = RepositoryImpl()
        val dataUseCase = DataUseCase(repository)
        val viewModelFactory = MainViewModelFactory(dataUseCase)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


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
        Snackbar.make(binding.root, text, Snackbar.LENGTH_INDEFINITE)
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .background(ContextCompat.getColor(this!!, R.color.red))
            .show()
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