package com.chintansoni.android.architecturecomponentsblueprint.util.bindingadapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by chintan.soni on 10/03/18.
 */
object ImageviewBinding {

    @BindingAdapter("image_url")
    fun setImageUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
                .load(url)
                .into(imageView)
    }
}
