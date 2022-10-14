package com.moaimar.psp2022.ut02.ex02.data.remote

import com.moaimar.psp2022.ut02.ex02.data.remote.models.AlertApiModel
import com.moaimar.psp2022.ut02.ex02.data.remote.models.ResponseApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {

    @GET("api/public/alerts")
    fun getResponse(): Call<ResponseApiModel>


    @GET("api/public/alerts/{id_alerts}")
    fun getAlertById(@Path("id_alerts") id : Int): Call<AlertApiModel>




}