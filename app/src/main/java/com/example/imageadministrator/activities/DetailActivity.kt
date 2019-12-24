package com.example.imageadministrator.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.imageadministrator.R
import com.example.imageadministrator.databinding.DetailLayoutBinding
import com.example.imageadministrator.viewmodels.DetailViewModel

class DetailActivity: AppCompatActivity() {

    lateinit var binding: DetailLayoutBinding
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.detail_layout
        )
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

    }
}