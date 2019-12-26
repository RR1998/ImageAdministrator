package com.example.imageadministrator.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageadministrator.R
import com.example.imageadministrator.adapter.ImageAdapter
import com.example.imageadministrator.database.PhotosDatabase
import com.example.imageadministrator.databinding.ActivityMainBinding
import com.example.imageadministrator.models.PhotosModel
import com.example.imageadministrator.viewmodels.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        viewModel = ViewModelProviders.of(this).get(MainViewModel(database = PhotosDatabase.getInstance(this))::class.java)
        binding.mainActivityViewModel =  viewModel
        viewModel.getListPhoto().observe(this, photosListObserver())
        viewModel.itemClickEvent.observe(this, clickObserver())
    }

    private fun clickObserver() = Observer<PhotosModel> {
        val detailClassIntent = Intent(
            this,
            DetailActivity::class.java
        )

        val bundle = Bundle()

        bundle.putParcelable(VariablesObject.BUNDLE_KEY, it)
        detailClassIntent.putExtras(bundle)
        ContextCompat.startActivity(this, detailClassIntent, null)
    }

    private fun photosListObserver() = Observer<List<PhotosModel>> {
        val adapter = ImageAdapter(it, viewModel.itemClickEvent)
        binding.photoViews.layoutManager = LinearLayoutManager(this)
        binding.photoViews.adapter = adapter
    }
}
