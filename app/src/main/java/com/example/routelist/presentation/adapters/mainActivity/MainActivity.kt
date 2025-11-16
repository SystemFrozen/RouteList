package com.example.routelist.presentation.adapters.mainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.routelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var adapter: RouteListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.routeListContainer.id, RouteListFragment())
                .commit()
        }

    }

}