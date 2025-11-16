package com.example.routelist.presentation.addRouteActivity.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemPassengerRouteBinding
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter

class PassengerInfoViewHolder(
    private val binding: ItemPassengerRouteBinding,
    private val router: CalendarPickerRouter
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.PassengerInfo) {

        binding.etPassengerTrainNumber.setText(item.trainNumber.toString())

        binding.etArrivalDate.setOnClickListener {
           router.show { dateTime ->
               item.startDate = dateTime
               binding.etArrivalDate.setText(dateTime)

           }
        }

        binding.etDepartureDate.setOnClickListener {
           router.show { dateTime ->
               item.endDate = dateTime
               binding.etDepartureDate.setText(dateTime)
           }
        }
    }



}