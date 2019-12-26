package com.example.imageadministrator.activities

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.imageadministrator.R
import com.example.imageadministrator.databinding.DetailLayoutBinding
import com.example.imageadministrator.models.PhotosModel
import com.example.imageadministrator.viewmodels.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailLayoutBinding

    private lateinit var detailViewModel: DetailViewModel

    private var photos: PhotosModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundleReceived = intent.extras
        bundleReceived?.getParcelable<PhotosModel>(VariablesObject.BUNDLE_KEY).let { photos = it }

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.detail_layout
        )

        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        binding.detailViewModel = detailViewModel
        setImageUrl(binding.detailedImage, photos)
    }

    private fun setImageUrl(view: ImageView, detailModel: PhotosModel?) {
        Glide.with(view.context).load(detailModel?.url)
            .into(view)
    }
}

