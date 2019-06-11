package com.rachelleboyette.catquiz.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rachelleboyette.catquiz.models.CatFact;
import com.rachelleboyette.catquiz.services.CatApiService;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public class CatFactViewModel extends ViewModel {
    private CatApiService catApiService = new CatApiService();
    private MutableLiveData<String> catFactText = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CatFactViewModel() {
        callCatFact();
    }

    private void callCatFact() {
        Disposable apiSubscription = catApiService.loadCatFact().subscribeWith(new DisposableSingleObserver<CatFact>() {
            @Override
            public void onSuccess(CatFact catFact) {
                publishCatFact(catFact);
            }

            @Override
            public void onError(Throwable e) {
                onApiError(e);
            }
        });

        compositeDisposable.add(apiSubscription);
    }

    private void onApiError(Throwable e) {

    }

    private void publishCatFact(CatFact catFact) {

    }
}
