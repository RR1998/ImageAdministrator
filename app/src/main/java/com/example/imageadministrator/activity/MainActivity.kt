package com.example.imageadministrator.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.domain.PhotosCleanModel
import com.example.imageadministrator.R
import com.example.imageadministrator.adapter.ImageAdapter
import com.example.imageadministrator.ImageAdminApp
import com.example.imageadministrator.databinding.ActivityMainBinding
import com.example.imageadministrator.eventhandler.Event
import com.example.imageadministrator.viewmodel.MainViewModel
import com.example.imageadministrator.viewmodel.viewmodelfactory.FactoryMainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        val viewModelFactory = FactoryMainViewModel((application as ImageAdminApp).useCase)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        binding.mainActivityViewModel = viewModel

        viewModel.getListPhoto().observe(this, photosListObserver())
        viewModel.itemClickEvent.observe(this, clickObserver())
    }

    private fun clickObserver() = Observer<Event<PhotosCleanModel>> { event ->
        event.getContentIfNotHandled()?.let {
            val detailClassIntent = Intent(
                this,
                DetailActivity::class.java

            )

            val bundle = Bundle()

            bundle.putString(VariablesObject.BUNDLE_KEY, it.url)
            detailClassIntent.putExtras(bundle)
            ContextCompat.startActivity(this, detailClassIntent, null)
        }

    }

    private fun photosListObserver() = Observer<List<PhotosCleanModel>> {

        val adapter = ImageAdapter(it, viewModel.itemClickEvent)

        binding.photoViews.layoutManager = LinearLayoutManager(this)
        binding.photoViews.adapter = adapter

    }
}
