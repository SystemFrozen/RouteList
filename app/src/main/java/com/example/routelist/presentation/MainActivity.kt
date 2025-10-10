package com.example.routelist.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.routelist.databinding.ActivityMainBinding
import com.example.routelist.presentation.adapters.RouteListAdapter

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: RouteListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = RouteListAdapter(emptyList())

        val layoutManager  = GridLayoutManager(this,2)

        layoutManager.spanSizeLookup = adapter.getCardSpanSize(2)

        binding.rvMain.layoutManager = layoutManager
        binding.rvMain.adapter = adapter

        viewModel.items.observe(this) { newItems ->
            adapter.submitList(newItems)
        }

    }
}