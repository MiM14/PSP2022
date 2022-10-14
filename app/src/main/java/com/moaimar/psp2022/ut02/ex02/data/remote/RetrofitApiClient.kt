package com.moaimar.psp2022.ut02.ex02.data.remote

import com.moaimar.psp2022.ut02.ex02.data.remote.models.ResponseApiModel
import com.moaimar.psp2022.ut02.ex02.data.remote.models.ResponseDetailApiModel
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

    fun getAlertById(alert_id: Int): ResponseDetailApiModel? {
        val callUser = apiEndPoints.getAlertById(alert_id)
        val response = callUser.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }

    fun getAlerts(): ResponseApiModel? {

        val callAlerts = apiEndPoints.getResponse()
        val response = callAlerts.execute()

        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }
}

