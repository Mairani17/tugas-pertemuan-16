package com.informatika19100092databarang.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class koneksi {

    companion object{
        val BaseUrl = "https://192.168.43.84/dabar/api/"
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service : ApiService = retrofit.create(ApiService::class.java)
    }
}