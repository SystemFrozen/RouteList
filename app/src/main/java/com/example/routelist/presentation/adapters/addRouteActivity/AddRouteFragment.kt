package com.example.routelist.presentation.adapters.addRouteActivity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.routelist.databinding.FragmentAddRouteBinding
import com.example.routelist.presentation.adapters.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.adapters.addRouteActivity.model.CalendarPickerRouter
import com.example.routelist.presentation.adapters.mainActivity.RouteApp


class AddRouteFragment : Fragment() {

    private var _binding: FragmentAddRouteBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: AddRouteAdapter
    private lateinit var items: MutableList<AddRouteListItem>
    lateinit var datePickerRouter: CalendarPickerRouter

    private val component by lazy {
        (requireActivity().application as RouteApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddRouteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        saveButton()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {

        val router = CalendarPickerRouter(requireContext())

        val items = mutableListOf(
            AddRouteListItem.RouteNumber(""),
            AddRouteListItem.DateRow("", "", ""),
            AddRouteListItem.TrainInfo("", 0, "", "", "", "", 0),
            AddRouteListItem.PassengerInfo("", "", "")
        )

        adapter = AddRouteAdapter(items, router)

        binding.rvAddRoute.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAddRoute.adapter = adapter
    }

    private fun saveButton() {
        binding.saveRoute.setOnClickListener {

            Toast.makeText(requireContext(), "Маршрут сохранён", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
        }
    }

}



