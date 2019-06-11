package com.rachelleboyette.catquiz.interfaces;

import com.rachelleboyette.catquiz.dtos.CatFactDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatFactApi {

    @GET("/fact?")
    Call<CatFactDto> getCatFact(@Query("max_length")int maxLength);
}
