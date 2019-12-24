package com.example.imageadministrator.overview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.imageadministrator.DetailActivity
import com.example.imageadministrator.network.PhotosModel

class PhotosViewModel(var photoItem : PhotosModel) : ViewModel(){
    //TODO remove context as parameter
    fun onClick(context: Context){
        val detailClassIntent = Intent(
            context,
            DetailActivity::class.java
        )
        val bundle = Bundle()
        bundle.putString("imageUrl", photoItem.url)
        detailClassIntent.putExtras(bundle)
        startActivity(context, detailClassIntent, null)
    }
}