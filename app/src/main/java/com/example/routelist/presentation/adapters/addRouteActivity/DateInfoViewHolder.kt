package com.example.routelist.presentation.adapters.addRouteActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemInputDateBinding
import com.example.routelist.presentation.adapters.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.adapters.addRouteActivity.model.CalendarPickerRouter


class DateInfoViewHolder(
    private val binding: ItemInputDateBinding,
    private val router: CalendarPickerRouter
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.DateRow) {
        binding.tvStartDate.setOnClickListener {
            router.show { dateTime ->
                item.startDate = dateTime
                binding.tvStartDate.setText(dateTime)
            }
        }

        binding.tvEndDate.setOnClickListener {
            router.show { dateTime ->
                item.endDate = dateTime
                binding.tvEndDate.setText(dateTime)
            }
        }

    }
}