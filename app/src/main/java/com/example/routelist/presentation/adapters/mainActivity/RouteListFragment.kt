package com.example.routelist.presentation.adapters.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.R
import com.example.routelist.databinding.FragmentMainBinding
import com.example.routelist.presentation.adapters.addRouteActivity.AddRouteAdapter
import com.example.routelist.presentation.adapters.addRouteActivity.AddRouteFragment
import com.example.routelist.presentation.adapters.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.adapters.mainActivity.model.RouteListItem
import com.example.routelist.presentation.adapters.mainActivity.model.RoutePosition
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RouteListFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RouteListAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var addNewRouteButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setupRecyclerView()

        binding.addNewRoute.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.route_list_container, AddRouteFragment())
                .addToBackStack(null)
                .commit()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


//    private fun setupRecyclerView() {
//
//
//
//        adapter = RouteListAdapter(items)
//
//        binding.rvMain.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvMain.adapter = adapter
//    }

   companion object {

   }
}

