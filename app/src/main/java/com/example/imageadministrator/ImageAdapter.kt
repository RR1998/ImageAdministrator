package com.example.imageadministrator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageadministrator.databinding.ImageListBinding
import com.example.imageadministrator.network.PhotosModel
import com.example.imageadministrator.viewmodels.PhotosViewModel

class ImageAdapter(imageList: List<PhotosModel>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

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
        fun bind(image: PhotosModel) {
            binding?.photosViewModel = PhotosViewModel(image)
            image.thumbnailUrl.let {
                val imgUri = it.toUri().buildUpon().scheme("https").build()
                if (binding != null) {
                    Glide.with(binding.imageContained.context)
                        .load(imgUri)
                        .into(binding.imageContained)
                }
            }
        }
    }
}