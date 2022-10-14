package com.moaimar.psp2022.ut02.ex01.data.remote

import com.moaimar.psp2022.ut02.ex01.data.remote.models.UserApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiEndPoint {

    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>


    @GET("users/{userId}")
    fun getUser(@Path("userId") id : Int):Call<UserApiModel>

}
