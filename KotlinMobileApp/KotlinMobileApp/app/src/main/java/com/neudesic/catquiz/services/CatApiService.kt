package com.neudesic.catquiz.services

import com.neudesic.catquiz.dtos.CatFactDto
import com.neudesic.catquiz.interfaces.CatFactApi
import com.neudesic.catquiz.models.CatFact
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatApiService  {
    private val url: String = "https://catfact.ninja/"
    private val catFactApi : CatFactApi
    private val length: Int = 140

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        catFactApi = retrofit.create(CatFactApi::class.java)
    }

    fun loadCatFact(): Single<CatFact> {
        return Single.create create@{ emitter ->
            val call = catFactApi.getCatFact(length)

            call.enqueue( object : Callback<CatFactDto> {
                override fun onFailure(call: Call<CatFactDto>, t: Throwable) {
                    emitter.onError(t)
                }

                override fun onResponse(call: Call<CatFactDto>, response: Response<CatFactDto?>) {
                   if (response.isSuccessful) {
                       val body = response.body()

                       val fromDto = CatFactDto.fromDto(body)

                       if (fromDto != null) {
                           emitter.onSuccess(fromDto)
                       }
                   }
                }
            })
            return@create
        }

    }
}