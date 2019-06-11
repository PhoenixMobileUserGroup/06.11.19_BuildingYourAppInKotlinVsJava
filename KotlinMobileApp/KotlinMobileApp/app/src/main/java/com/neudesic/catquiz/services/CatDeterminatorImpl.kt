package com.neudesic.catquiz.services

import com.neudesic.catquiz.R
import com.neudesic.catquiz.interfaces.CatDeterminator

class CatDeterminatorImpl : CatDeterminator {
    private var catResults : List<Int> = listOf(R.drawable.cat_sphynx,
                        R.drawable.cat_calico,
                        R.drawable.cat_domestic_long_hair,
                        R.drawable.cat_domestic_short_hair,
                        R.drawable.cat_egyptian_mau,
                        R.drawable.cat_maine_coon,
                        R.drawable.cat_norwegian_forest_cat,
                        R.drawable.cat_persian,
                        R.drawable.cat_manx,
                        R.drawable.cat_tortoiseshell)

    override fun getCatResult(): Int {
        return catResults[(0 until catResults.size).random()]
    }
}