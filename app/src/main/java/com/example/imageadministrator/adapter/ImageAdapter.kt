package com.example.imageadministrator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.domain.PhotosCleanModel
import com.example.imageadministrator.R
import com.example.imageadministrator.databinding.ImageListBinding
import com.example.imageadministrator.eventhandlers.Event
import com.example.imageadministrator.viewmodels.PhotosViewModel

/**
 * ImageAdapter is the class that fills the RecyclerViews to add it into the MainActivity view
 */

class ImageAdapter(
    imageList: List<PhotosCleanModel>,
    var clickEvent: MutableLiveData<Event<PhotosCleanModel>>
) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private var images = imageList

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.image_list, parent, false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ImageListBinding? = DataBindingUtil.bind(view)
        fun bind(image: PhotosCleanModel) {
            binding?.photosViewModel = PhotosViewModel(image, clickEvent)
            image.thumbnailUrl.let {
                if (binding != null) {
                    Glide.with(binding.imageContained.context)
                        .load(it)
                        .into(binding.imageContained)
                }
            }
        }
    }
}