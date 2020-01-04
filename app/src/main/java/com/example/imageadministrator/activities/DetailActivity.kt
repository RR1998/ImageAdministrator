package com.example.imageadministrator.activities

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.core.domain.PhotosCleanModel
import com.example.imageadministrator.R
import com.example.imageadministrator.databinding.DetailLayoutBinding
import com.example.imageadministrator.viewmodels.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailLayoutBinding

    private lateinit var detailViewModel: DetailViewModel

    private var photosClean: PhotosCleanModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundleReceived = intent.extras
        bundleReceived?.getParcelable<PhotosCleanModel>(VariablesObject.BUNDLE_KEY)
            .let { photosClean = it }

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.detail_layout
        )

        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        binding.detailViewModel = detailViewModel
        setImageUrl(binding.detailedImage, photosClean)
    }

    private fun setImageUrl(view: ImageView, detailCleanModel: PhotosCleanModel?) {
        Glide.with(view.context).load(detailCleanModel?.url)
            .into(view)
    }
}

