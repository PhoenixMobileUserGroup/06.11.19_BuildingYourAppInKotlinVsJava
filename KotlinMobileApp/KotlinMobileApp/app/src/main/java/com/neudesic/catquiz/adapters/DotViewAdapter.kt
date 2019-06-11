package com.neudesic.catquiz.adapters

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.databinding.BindingAdapter
import com.neudesic.catquiz.R
import com.neudesic.catquiz.customviews.DotView

@BindingAdapter("app:isActive")
fun bindIsActive(view: ImageView?, field: Boolean ) {

    if(field) view?.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(view!!.context, R.color.selectedColor))
    else view?.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(view!!.context, R.color.colorWhite))
}

