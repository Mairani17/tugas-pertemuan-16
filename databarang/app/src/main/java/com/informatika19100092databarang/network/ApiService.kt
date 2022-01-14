package com.informatika19100092databarang.network

import com.informatika19100092databarang.model.ResponseActionBarang
import com.informatika19100092databarang.model.ResponseBarang
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    fun getUser() : Call<List>ResponseUserItemn?>>
        @GET("read.php")
        fun getBarang() : Call<ResponseBarang>
        @FormUrlEncoded
        @POST("create.php")
        fun insertBarang(
            @Field("Nama_barang") namaBarang: String?,
            @Field("Jumlah_barang") jmlBarang: String?
        ): Call<ResponseActionBarang>

        @FormUrlEncoded
        @POST("update.php")
        fun updateBarang(
            @Field("id") id:String?,
            @Field("Nama_Barang") namaBarang: String?,
            @Field("JumlahBarang") jmlBarang: String?
        ): Call<ResponseActionBarang>

        @FormUrlEncoded
        @POST("delete.php")
        fun deleteBarang(
            @Field("id") id: String?
        ): Call<ResponseActionBarang>

        @FormUrlEncoded
        @POST("login.php")
        fun login(
            @Field("Username") Username : String?,
            @Field("Password") Password : String?
        ): Call<ResponseAdmin>
        @FormUrlEncoded
        @POST
        fun register(
            @Field("Username") Username : String?,
            @Field("Password") Password : String?
        ): Call<ResponseAdmin>
}