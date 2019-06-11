package com.neudesic.catquiz.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neudesic.catquiz.services.CatApiService
import com.neudesic.catquiz.models.CatFact
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class CatFactViewModel: ViewModel() {
    private var catApiService: CatApiService = CatApiService()
    var catFactText: MutableLiveData<String> = MutableLiveData()
    private var apiSubscription : CompositeDisposable = CompositeDisposable()

     init {
         callCatFact()
    }

    private fun publishCatFact(catFact: CatFact?) {
        catFactText.postValue(catFact?.fact)
    }

    private fun callCatFact() {
        val apiObserver = catApiService.loadCatFact().subscribeBy (
            onError = {
                onApiError(it)
            },
            onSuccess = {
                publishCatFact(it)
            }
        )

        apiSubscription.add(apiObserver)
    }

    private fun onApiError(error: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}