package com.example.mintostest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // component.inject(this)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       /* viewModel.method()*/

        load()

        binding.IBANBlock.header.text = "Beneficiary bank account number / IBAN"
        binding.SwiftBlock.header.text = "Beneficiary bank SWIFT / BIC code"
        binding.BeneficiaryBlock.header.text = "Beneficiary name"
        binding.BeneficiaryAddressBlock.header.text = "Beneficiary bank address"
        binding.investorId.header.text = "Add this information to payment details"




    }

   fun load(){}

}