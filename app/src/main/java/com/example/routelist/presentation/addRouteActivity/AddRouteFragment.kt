package com.example.routelist.presentation.addRouteActivity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.routelist.databinding.FragmentAddRouteBinding
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter
import com.example.routelist.presentation.addRouteActivity.model.TextChangedImpl
import com.example.routelist.presentation.mainActivity.RouteApp
import com.example.routelist.presentation.mainActivity.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject


class AddRouteFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    private var _binding: FragmentAddRouteBinding? = null
    private val binding: FragmentAddRouteBinding
        get() = _binding!!


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


        lifecycleScope.launch {
            viewModel.items.flowWithLifecycle(lifecycle).collect {
            }
        }
        lifecycleScope.launch {
            viewModel.errorFlow.flowWithLifecycle(lifecycle).collect {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
        val dateRowInfo = viewModel.items.value[1] as AddRouteListItem.DateRow
        val passenger = viewModel.items.value[3] as AddRouteListItem.PassengerInfo
        addTextChangeListeners()

        setupDateRow(dateRowInfo)

        setupPassengerInfo(passenger)

        setupRecyclerView()

        saveButton()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {

        val router = CalendarPickerRouter(requireContext())


    }

    fun addTextChangeListeners() {

        binding.etRouteNumber.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[0] as AddRouteListItem.RouteNumber
                val newNumber = oldNumber.copy(number = text)
                viewModel.updateItem(0, newNumber)
            }
        )

        binding.etTrainNumber.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[2] as AddRouteListItem.TrainInfo
                val newNumber = oldNumber.copy(trainNumber = text)
                viewModel.updateItem(2, newNumber)
            }
        )

        binding.etComposition.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[2] as AddRouteListItem.TrainInfo
                val newNumber = oldNumber.copy(composition = text)
                viewModel.updateItem(2, newNumber)
            }
        )

        binding.etStationFrom.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[2] as AddRouteListItem.TrainInfo
                val newNumber = oldNumber.copy(startStation = text)
                viewModel.updateItem(2, newNumber)
            }
        )

        binding.etStationTo.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[2] as AddRouteListItem.TrainInfo
                val newNumber = oldNumber.copy(endStation = text)
                viewModel.updateItem(2, newNumber)
            }
        )

        binding.etDistance.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[2] as AddRouteListItem.TrainInfo
                val newNumber = oldNumber.copy(distance = text)
                viewModel.updateItem(2, newNumber)
            }
        )

        binding.etStops.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[2] as AddRouteListItem.TrainInfo
                val newNumber = oldNumber.copy(stopsCount = text)
                viewModel.updateItem(2, newNumber)
            }
        )

        binding.etPassengerTrainNumber.addTextChangedListener(
            TextChangedImpl { text ->
                val oldNumber = viewModel.items.value[3] as AddRouteListItem.PassengerInfo
                val newNumber = oldNumber.copy(passengerTrainNumber = text)
                viewModel.updateItem(3, newNumber)
            }
        )
    }

    fun setupDateRow(item: AddRouteListItem.DateRow) {
        binding.tvStartDate.setText(item.startDate)
        binding.tvEndDate.setText(item.endDate)

        binding.tvStartDate.setOnClickListener {
            CalendarPickerRouter(requireContext()).show { dateTime ->
                val old = viewModel.items.value[1] as AddRouteListItem.DateRow
                val updated = old.copy(startDate = dateTime)
                viewModel.updateItem(1, updated)
                binding.tvStartDate.setText(dateTime)
            }
        }

        binding.tvEndDate.setOnClickListener {
            CalendarPickerRouter(requireContext()).show { dateTime ->
                val old = viewModel.items.value[1] as AddRouteListItem.DateRow
                val updated = old.copy(endDate = dateTime)
                viewModel.updateItem(1, updated)
                binding.tvEndDate.setText(dateTime)
            }
        }

    }

    fun setupPassengerInfo(item: AddRouteListItem.PassengerInfo) {
        binding.etArrivalDate.setText(item.passengerStartDate)
        binding.etDepartureDate.setText(item.passengerEndDate)


        binding.etArrivalDate.setOnClickListener {
            CalendarPickerRouter(requireContext()).show { dateTime ->
                val updated = item.copy(passengerStartDate = dateTime)
                viewModel.updateItem(3, updated)
                binding.etArrivalDate.setText(dateTime)
            }
        }

        binding.etDepartureDate.setOnClickListener {
            CalendarPickerRouter(requireContext()).show { dateTime ->
                val updated = item.copy(passengerEndDate = dateTime)
                viewModel.updateItem(3, updated)
                binding.etDepartureDate.setText(dateTime)
            }
        }

    }


    private fun saveButton() {

        binding.saveRoute.setOnClickListener {
            viewModel.validate()

            // Это потом через вью модель вызывать надо будет
            viewModel.saveRoute()
//
            Toast.makeText(requireContext(), "Маршрут сохранён", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()

        }

    }
}



