package com.neudesic.catquiz.interfaces

import com.neudesic.catquiz.dtos.CatFactDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatFactApi {
    @GET("/fact?")
    fun getCatFact(@Query("max_length") maxLength: Int): Call<CatFactDto>
}