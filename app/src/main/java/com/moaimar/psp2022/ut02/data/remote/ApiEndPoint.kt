package com.moaimar.psp2022.ut02.data.remote

import com.moaimar.psp2022.ut02.data.remote.models.UserApiModel
import retrofit2.Call


interface ApiEndPoint {

    fun getUsers(): Call<List<UserApiModel>>


}