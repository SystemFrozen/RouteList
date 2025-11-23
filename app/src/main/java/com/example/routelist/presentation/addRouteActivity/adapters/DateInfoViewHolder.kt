package com.example.routelist.presentation.addRouteActivity.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemInputDateBinding
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter


class DateInfoViewHolder(
    private val binding: ItemInputDateBinding,
    private val router: CalendarPickerRouter,
    private val onChange: (Int, AddRouteListItem.DateRow) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.DateRow) {
        binding.tvStartDate.setText(item.startDate)
        binding.tvEndDate.setText(item.endDate)

//тут проблема в том, что данные вводятся, но на выводе остается только, этот пропадает
        binding.tvStartDate.setOnClickListener {
            router.show { dateTime ->
                val updated = item.copy(startDate = dateTime)

                onChange(bindingAdapterPosition, updated)

                binding.tvStartDate.setText(dateTime)
            }
        }
// вот этот
        binding.tvEndDate.setOnClickListener {
            router.show { dateTime ->

                val updated = item.copy(endDate = dateTime)

                onChange(bindingAdapterPosition, updated)

                binding.tvEndDate.setText(dateTime)
            }
        }

    }
}