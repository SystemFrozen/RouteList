package com.example.routelist.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemHeaderBinding


class CalendarViewHolder(private val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        binding.tvCalendarHeader.text = "Сентябрь 2025"
    }
}