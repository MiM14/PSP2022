package com.moaimar.psp2022.ut02.ex01.data.remote

import com.moaimar.psp2022.ut02.ex01.data.remote.models.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitApiClient {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com"

    private var apiEndPoint: ApiEndPoint

        init {
            apiEndPoint =buildApiEndPoint()
        }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoint() : ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    fun getUser(userId: Int): UserApiModel?{
        val callUser = apiEndPoint.getUser(userId)
        val response = callUser.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }

    fun getUsers(): List<UserApiModel>? {
        val callUsers = apiEndPoint.getUsers()
        val response = callUsers.execute()

        return if(response.isSuccessful){
            response.body()
        }else{
            emptyList()
        }



        /*Otra manera
        if(response.isSuccessful){
            val users = response.body()
            return users ?: emptyList()
        }else{
            return emptyList<UserApiModel>()
        }*/
    }
}