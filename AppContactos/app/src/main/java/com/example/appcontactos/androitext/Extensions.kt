package com.example.appcontactos.androitext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .circleCrop()
        .into(this)
}