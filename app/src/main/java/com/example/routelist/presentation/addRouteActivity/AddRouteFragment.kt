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

    private lateinit var viewModel: AddRouteViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentAddRouteBinding? = null
    private val binding: FragmentAddRouteBinding
        get() = _binding ?: throw RuntimeException("FragmentAddRouteBinding is null")

    private lateinit var adapter: AddRouteAdapter


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

        viewModel = ViewModelProvider(this, viewModelFactory)[AddRouteViewModel::class]

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

            adapter.getItems().forEachIndexed { index, item ->
                viewModel.updateItem(index, item)
            }


            // сохраняем маршрут через ViewModel
            viewModel.saveRoute()

            Toast.makeText(requireContext(), "Маршрут сохранён", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack() // возвращаемся на список маршрутов

        }

    }

}



