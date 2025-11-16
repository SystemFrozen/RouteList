package com.example.routelist.presentation.adapters.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.R
import com.example.routelist.databinding.FragmentMainBinding
import com.example.routelist.presentation.adapters.addRouteActivity.AddRouteFragment
import com.example.routelist.presentation.adapters.mainActivity.model.RouteListItem
import com.example.routelist.presentation.adapters.mainActivity.model.RoutePosition
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RouteListFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RouteListAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var addNewRouteButton: FloatingActionButton

    private val _items = MutableLiveData<List<RouteListItem>>()
    val items: LiveData<List<RouteListItem>> get() = _items

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNewRoute.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.route_list_container, AddRouteFragment())
                .addToBackStack(null)
                .commit()
        }

        loadData()
//        setupRecyclerView()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadData() {
        val uiItems = mutableListOf<RouteListItem>()

        // календарь
        uiItems.add(RouteListItem.CalendarHeader("Сентябрь 2025"))

        // карточки
        uiItems.add(RouteListItem.Card("Норма часов", "184"))
        uiItems.add(RouteListItem.Card("Норма на сегодня", "64"))
        uiItems.add(RouteListItem.Card("Всего", "24:00"))
        uiItems.add(RouteListItem.Card("Пассажиром", "0:00"))
        uiItems.add(RouteListItem.Card("Ночных", "6:12"))

        // заголовок маршрутов
        uiItems.add(RouteListItem.RoutesHeader)

        // маршруты
        uiItems.add(
            RouteListItem.RouteItem(
                "123",
                "01.09 08:00",
                "01.09 16:00",
                "8",
                RoutePosition.First
            )
        )
        uiItems.add(
            RouteListItem.RouteItem(
                "123",
                "01.09 08:00",
                "01.09 16:00",
                "8",
                RoutePosition.Middle
            )
        )
        uiItems.add(
            RouteListItem.RouteItem(
                "456",
                "02.09 09:00",
                "02.09 18:00",
                "9",
                RoutePosition.Last
            )
        )

        _items.value = uiItems
    }

//
//    private fun setupRecyclerView() {
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

