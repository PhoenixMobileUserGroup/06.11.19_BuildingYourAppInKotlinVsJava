package com.neudesic.catquiz.viewmodels

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neudesic.catquiz.MainActivity
import com.neudesic.catquiz.R
import com.neudesic.catquiz.interfaces.CatDeterminator

class CatResultViewModel( val catDeterminator: CatDeterminator): ViewModel() {
    val result : MutableLiveData<Int> =  MutableLiveData<Int>()
    val catResultTextData : MutableLiveData<String> = MutableLiveData<String>()

    fun completeQuiz() {
        determineResult()
    }

    private fun determineResult() {
        val catType = catDeterminator.getCatResult()

        result.value = catType

        when(catType) {
            R.drawable.cat_calico -> catResultTextData.value = "Calico"
            R.drawable.cat_domestic_long_hair -> catResultTextData.value = "Domestic Long Hair"
            R.drawable.cat_domestic_short_hair -> catResultTextData.value = "Domestic Short Hair"
            R.drawable.cat_egyptian_mau -> catResultTextData.value = "Egyptian Mau"
            R.drawable.cat_maine_coon -> catResultTextData.value = "Maine Coon"
            R.drawable.cat_norwegian_forest_cat -> catResultTextData.value = "Norwegian Forest"
            R.drawable.cat_persian -> catResultTextData.value = "Persian"
            R.drawable.cat_manx -> catResultTextData.value = "Manx"
            R.drawable.cat_tortoiseshell -> catResultTextData.value = "Tortishell"
        }
    }

    fun onButtonTakeMeHomeClicked(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}