package com.moaimar.psp2022.ut02.ex02.data.remote.models

data class ResponseApiModel(val statusCode: String, val data: List<AlertApiModel>)
data class AlertApiModel(val alert_id: Int, val title: String, val summary: String, val type: Int, val date:String)

data class ResponseDetailApiModel(val statusCode: String, val data: AlertDetailApiModel)
data class AlertDetailApiModel(val alert_id: Int, val title: String, val summary: String, val type: Int, val date:String, val body: String,val source:String, val files: List<FileApiModel>)
data class FileApiModel(val id : Int,val alert_id:Int, val name : String, val url: String)

