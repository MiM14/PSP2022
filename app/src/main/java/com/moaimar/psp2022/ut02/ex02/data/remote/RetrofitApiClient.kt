package com.moaimar.psp2022.ut02.ex02.data.remote

import com.moaimar.psp2022.ut02.ex02.data.remote.models.ResponseApiModel
import com.moaimar.psp2022.ut02.ex02.data.remote.models.AlertApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {

    private val urlEndPoint = "https://plagricola.sitehub.es"

    private var apiEndPoints: ApiEndPoints
        init {
             apiEndPoints =buildApiEndPoint()
        }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoint() : ApiEndPoints {
        return buildClient().create(ApiEndPoints::class.java)
    }

    fun getAlertById(alert_id: Int): AlertApiModel? {
        val callUser = apiEndPoints.getAlertById(alert_id)
        val response = callUser.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }

    fun getResponse(): ResponseApiModel ?{
        val callUsers = apiEndPoints.getResponse()
        val response = callUsers.execute()

        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }
}

