package com.neudesic.catquiz.customviews

import android.content.Context
import android.util.AttributeSet
import com.neudesic.catquiz.R

class CatQuizCompletionView(context: Context, attrs: AttributeSet): androidx.appcompat.widget.AppCompatImageView(context, attrs) {
    var completionRate : Int = 0
        set(value) {
            when (value) {
                0 -> setImageResource(R.drawable.ic_catcardicons_01)
                25 -> setImageResource(R.drawable.ic_catcardicons_02)
                50 -> setImageResource(R.drawable.ic_catcardicons_03)
                75 -> setImageResource(R.drawable.ic_catcardicons_04)
                100 -> setImageResource(R.drawable.ic_catcardicon_05)
                else -> setImageResource(R.drawable.ic_catcardicons_01)
            }
            field = value
        }
}