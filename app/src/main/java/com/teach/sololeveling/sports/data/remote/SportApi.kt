package com.teach.sololeveling.sports.data.remote

import com.teach.sololeveling.core.utils.AppConstants.API_KEY
import com.teach.sololeveling.core.utils.AppConstants.BASE_URL
import com.teach.sololeveling.core.utils.AppConstants.HOST
import com.teach.sololeveling.sports.data.remote.dto.SportDto
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface SportApi {
    @Headers(
        "X-RapidAPI-Key: $API_KEY",
        "X-RapidAPI-Host: $HOST",

    )
    @GET("sports?all=true")
    suspend fun getSports(): List<SportDto>

}