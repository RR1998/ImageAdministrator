package com.example.imageadministrator.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.imageadministrator.R
import com.example.imageadministrator.activity.MainActivity.Companion.BUNDLE_KEY
import com.example.imageadministrator.databinding.DetailLayoutBinding
import com.example.imageadministrator.viewmodel.DetailViewModel

/**
 * DetailActivity that shows a zoomed image from the selected in the main activity
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailLayoutBinding

    private lateinit var detailViewModel: DetailViewModel

    private var photosUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val bundleReceived = intent.extras
        bundleReceived?.getString(BUNDLE_KEY)
            .let { photosUrl = it }

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.detail_layout
        )

        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        binding.detailViewModel = detailViewModel
        setImageUrl(binding.detailedImage, photosUrl)
    }

    private fun setImageUrl(view: ImageView, detailUrl: String?) =
        Glide.with(view.context).load(detailUrl)
            .into(view)
}

