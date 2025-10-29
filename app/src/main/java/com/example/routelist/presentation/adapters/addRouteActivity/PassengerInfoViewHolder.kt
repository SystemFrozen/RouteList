package com.example.routelist.presentation.adapters.addRouteActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemPassengerRouteBinding
import com.example.routelist.presentation.adapters.addRouteActivity.model.AddRouteListItem

class PassengerInfoViewHolder(
    private val binding: ItemPassengerRouteBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.PassengerInfo){
        binding.etPassengerTrainNumber.setText(item.trainNumber.toString())
        binding.etArrivalDate.setText(item.startDate.toString())
        binding.etDepartureDate.setText(item.endDate.toString())
    }
}