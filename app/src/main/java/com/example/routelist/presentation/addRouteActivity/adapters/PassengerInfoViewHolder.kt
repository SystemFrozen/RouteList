package com.example.routelist.presentation.addRouteActivity.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemPassengerRouteBinding
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter

class PassengerInfoViewHolder(
    private val binding: ItemPassengerRouteBinding,
    private val router: CalendarPickerRouter,
    private val onChange: (Int, AddRouteListItem.PassengerInfo) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.PassengerInfo) {

        binding.etPassengerTrainNumber.setText(item.passengerTrainNumber.toString())
        binding.etArrivalDate.setText(item.passengerStartDate)
        binding.etDepartureDate.setText(item.passengerEndDate)


        binding.etArrivalDate.setOnClickListener {
            router.show { dateTime ->
                val updated = item.copy(passengerStartDate = dateTime)
                onChange(bindingAdapterPosition, updated)

                binding.etArrivalDate.setText(dateTime)
            }
        }
        // вот этот
        binding.etDepartureDate.setOnClickListener {
            router.show { dateTime ->
                val updated = item.copy(passengerEndDate = dateTime)
                onChange(bindingAdapterPosition, updated)

                binding.etDepartureDate.setText(dateTime)
            }
        }
    }


}