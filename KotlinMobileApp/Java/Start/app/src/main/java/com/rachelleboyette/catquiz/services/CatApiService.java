package com.rachelleboyette.catquiz.services;

import com.rachelleboyette.catquiz.dtos.CatFactDto;
import com.rachelleboyette.catquiz.interfaces.CatFactApi;
import com.rachelleboyette.catquiz.models.CatFact;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatApiService {
    private String apiUrl = "https://catfact.ninja/";
    private int maxLength = 140;
    private CatFactApi service;

    public CatApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(CatFactApi.class);
    }

    public Single<CatFact> loadCatFact() {
        return Single.create(new SingleOnSubscribe<CatFact>() {
            @Override
            public void subscribe(final SingleEmitter<CatFact> emitter) throws Exception {
                Call call = service.getCatFact(maxLength);

                call.enqueue(new Callback<CatFactDto>() {
                    @Override
                    public void onResponse(Call<CatFactDto> call, Response<CatFactDto> response) {
                        if (response.isSuccessful()) {
                            CatFactDto body = response.body();

                            CatFact fromDto = CatFactDto.fromDto(body);

                            emitter.onSuccess(fromDto);
                        }
                    }

                    @Override
                    public void onFailure(Call<CatFactDto> call, Throwable t) {
                        emitter.onError(t);
                    }
                });
            }
        });
    }
}