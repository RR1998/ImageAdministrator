package com.example.imageadministrator.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.domain.PhotosCleanModel
import com.example.imageadministrator.R
import com.example.imageadministrator.adapter.ImageAdapter
import com.example.imageadministrator.databinding.ActivityMainBinding
import com.example.imageadministrator.eventhandler.Event
import com.example.imageadministrator.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModelInstance: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.mainActivityViewModel = mainViewModelInstance

        mainViewModelInstance.getListPhoto().observe(this, photosListObserver())
        mainViewModelInstance.itemClickEvent.observe(this, clickObserver())
    }

    private fun clickObserver() =
        Observer<Event<PhotosCleanModel>> { event ->
            event.getContentIfNotHandled()?.let {

                val detailClassIntent = Intent(
                    this,
                    DetailActivity::class.java
                )

                val bundle = Bundle()

                bundle.putString(BUNDLE_KEY, it.url)
                detailClassIntent.putExtras(bundle)
                ContextCompat.startActivity(this, detailClassIntent, null)
            }
        }

    private fun photosListObserver() =
        Observer<List<PhotosCleanModel>> {

            val adapter = ImageAdapter(it, mainViewModelInstance.itemClickEvent)

            binding.photoViews.layoutManager = LinearLayoutManager(this)
            binding.photoViews.adapter = adapter
        }

    companion object {
        const val BUNDLE_KEY = "imageModel"
    }
}
