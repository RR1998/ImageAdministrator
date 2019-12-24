package com.example.imageadministrator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.imageadministrator.databinding.ActivityMainBinding
import com.example.imageadministrator.viewmodels.DetailViewModel

class DetailActivity: AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.detail_layout)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

    }
}