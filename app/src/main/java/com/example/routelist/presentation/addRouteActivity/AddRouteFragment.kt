package com.example.routelist.presentation.addRouteActivity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.routelist.databinding.FragmentAddRouteBinding
import com.example.routelist.presentation.addRouteActivity.adapters.AddRouteAdapter
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter
import com.example.routelist.presentation.mainActivity.RouteApp
import com.example.routelist.presentation.mainActivity.ViewModelFactory
import javax.inject.Inject


class AddRouteFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    private var _binding: FragmentAddRouteBinding? = null
    private val binding: FragmentAddRouteBinding
        get() = _binding!!


    private lateinit var adapter: AddRouteAdapter


    val viewModel: AddRouteViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[AddRouteViewModel::class]
    }

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
            AddRouteListItem.TrainInfo("", "", "", "", "", ""),
            AddRouteListItem.PassengerInfo("", "", "")
        )

        adapter = AddRouteAdapter(items, router)
        binding.rvAddRoute.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAddRoute.adapter = adapter
    }


    private fun saveButton() {

        binding.saveRoute.setOnClickListener {

            val items = adapter.getItems()

            if (!validate(items)) {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            adapter.getItems().forEachIndexed { index, item ->
                viewModel.updateItem(index, item)
            }


            viewModel.saveRoute()

            Toast.makeText(requireContext(), "Маршрут сохранён", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()

        }

    }

    //validate я потом перенесу в viewModel
    private fun validate(items: List<AddRouteListItem>): Boolean {
        items.forEach { item ->
            when (item) {
                is AddRouteListItem.RouteNumber -> {
                    if (item.number.isBlank()) return false
                }

                is AddRouteListItem.DateRow -> {
                    if (item.startDate.isBlank() || item.endDate.isBlank()) return false
                }

                else -> return false
            }
        }
        return true
    }

}



