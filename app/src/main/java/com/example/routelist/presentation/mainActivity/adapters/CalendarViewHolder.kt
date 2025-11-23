package com.example.routelist.presentation.mainActivity.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemHeaderBinding
import com.example.routelist.presentation.mainActivity.model.MonthYearPickerRouter
import com.example.routelist.presentation.mainActivity.model.RouteListItem

class CalendarViewHolder(
    private val binding: ItemHeaderBinding,
    private val router: MonthYearPickerRouter
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RouteListItem.CalendarHeader) {
        binding.tvCalendarHeader.text = "${router.getMonthName(item.month)} ${item.year}"

        binding.tvCalendarHeader.setOnClickListener {
            router.show(item.month,item.year) { monthName, month, year ->
                item.month = month
                item.year = year
                binding.tvCalendarHeader.text = "$monthName $year"
            }
        }
    }
}