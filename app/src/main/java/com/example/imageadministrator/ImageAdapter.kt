package com.example.imageadministrator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.imageadministrator.databinding.ImageListBinding
import com.example.imageadministrator.network.PhotosModel
import com.example.imageadministrator.overview.PhotosViewModel

class ImageAdapter(imageList: List<PhotosModel>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private var images = imageList

/*    fun recyclerAdapter(images: MutableList<PhotosModel>) {
        this.images = images
    }*/


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  ViewHolder(layoutInflater.inflate(R.layout.image_list, parent, false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ImageListBinding? = DataBindingUtil.bind(view)
        fun bind(image: PhotosModel) {
            binding?.photosViewModel = PhotosViewModel(image)
        }
    }
}