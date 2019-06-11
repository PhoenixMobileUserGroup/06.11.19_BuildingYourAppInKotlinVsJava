package com.neudesic.catquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neudesic.catquiz.adapters.CatQuizViewAdapter
import com.neudesic.catquiz.models.CatQuizModelStore
import com.neudesic.catquiz.viewmodels.CatFactViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var catFactViewModel : CatFactViewModel
    private lateinit var catQuizViewAdapter: CatQuizViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catFactViewModel = ViewModelProviders.of(this).get(CatFactViewModel::class.java)

        catFactViewModel.catFactText.observe(this, Observer {
            updateFactText(catFactViewModel.catFactText.value)
        })

        setupViews()
    }

    private fun updateFactText(fact: String?) {
        catFactText.text = fact
    }

    private fun setupViews() {
        CatQuizModelStore.loadQuizzes()
        catQuizViewAdapter = CatQuizViewAdapter(CatQuizModelStore.getQuizzes())

        catQuizRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2, RecyclerView.VERTICAL, false)
        catQuizRecyclerView.adapter = catQuizViewAdapter
    }

    override fun onResume() {
        super.onResume()
        catQuizRecyclerView.adapter = CatQuizViewAdapter(CatQuizModelStore.getQuizzes())
    }
}