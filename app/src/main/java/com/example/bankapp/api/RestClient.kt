package com.example.bankapp.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    companion object {
        private var restrofitClient : Retrofit? = null

        fun getClient() : Retrofit{
            if(restrofitClient==null){
                var gson = GsonBuilder().setDateFormat("dd/MM/yyyy").create()
                restrofitClient = Retrofit.Builder()
                    .baseUrl("https://bank-app-test.herokuapp.com/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return restrofitClient!!
        }
    }

}