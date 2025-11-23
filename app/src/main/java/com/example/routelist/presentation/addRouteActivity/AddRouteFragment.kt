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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.routelist.databinding.FragmentAddRouteBinding
import com.example.routelist.presentation.addRouteActivity.adapters.AddRouteAdapter
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter
import com.example.routelist.presentation.mainActivity.RouteApp
import com.example.routelist.presentation.mainActivity.ViewModelFactory
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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
        lifecycleScope.launch {
            viewModel.items.flowWithLifecycle(lifecycle).collect {
                adapter.populate(it)
            }
        }
        lifecycleScope.launch {
            viewModel.errorFlow.flowWithLifecycle(lifecycle).collect {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
        setupRecyclerView()
        saveButton()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {

        val router = CalendarPickerRouter(requireContext())

        adapter = AddRouteAdapter(router, viewModel)
        binding.rvAddRoute.itemAnimator = null
        binding.rvAddRoute.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAddRoute.adapter = adapter
    }


    private fun saveButton() {

        binding.saveRoute.setOnClickListener {
            viewModel.validate()

            // Это потом через вью модель вызывать надо будет
//            viewModel.saveRoute()
//
//            Toast.makeText(requireContext(), "Маршрут сохранён", Toast.LENGTH_SHORT).show()
//            parentFragmentManager.popBackStack()

        }

    }
}



