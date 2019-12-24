package com.example.imageadministrator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageadministrator.databinding.ActivityMainBinding
import com.example.imageadministrator.viewmodels.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        showData()
    }


    private fun showData(){
        binding.viewModel?.getListPhoto()?.observe(this, Observer {
            val adapter = ImageAdapter(it)
            binding.photoViews.layoutManager = LinearLayoutManager(this)
            binding.photoViews.adapter = adapter
        })

    }

}
