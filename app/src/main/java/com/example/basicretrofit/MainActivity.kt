package com.example.basicretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.basicretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton.setOnClickListener {
            lifecycleScope.launch (Dispatchers.IO){
                getResponse()
            }
        }

    }

    fun retrofitResponse ():Retrofit{
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
                GsonConverterFactory.create()).build()
    }

    suspend fun getResponse() {
        val call = retrofitResponse().create(apiservice::class.java).getComentarios()
        if (call.isSuccessful){
           println(call.body().contentToString())
        }
    }
}