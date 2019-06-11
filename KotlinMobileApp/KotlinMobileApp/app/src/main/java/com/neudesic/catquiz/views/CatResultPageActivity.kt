package com.neudesic.catquiz.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.neudesic.catquiz.R
import com.neudesic.catquiz.helpers.CatResultViewModelFactory
import com.neudesic.catquiz.interfaces.CatDeterminator
import com.neudesic.catquiz.services.CatDeterminatorImpl
import com.neudesic.catquiz.viewmodels.CatResultViewModel
import kotlinx.android.synthetic.main.cat_result_page.*

class CatResultPageActivity: AppCompatActivity() {
    private lateinit var catResultPageViewModel : CatResultViewModel
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.cat_result_page)

        initializeViewModel()
        setBindings()
        catResultPageViewModel.completeQuiz()
    }

    private fun setBindings() {
        catResultPageViewModel.result.observe(this, Observer {
            updateImageResource(catResultPageViewModel.result.value)
        })
        catResultPageViewModel.catResultTextData.observe(this, Observer {
            updateResultText(catResultPageViewModel.catResultTextData.value)
        })
        takeMeHomeButton.setOnClickListener {
            catResultPageViewModel.onButtonTakeMeHomeClicked(it.context)
        }
    }

    private fun updateResultText(value: String?) {
        catTypeText.text = value!!
    }

    private fun updateImageResource(value: Int?) {
        resultImageView.setImageResource(value!!)
    }

    private fun initializeViewModel() {
        catResultPageViewModel = ViewModelProviders.of(this, CatResultViewModelFactory(catDeterminator = CatDeterminatorImpl())).get(CatResultViewModel::class.java)

    }
}