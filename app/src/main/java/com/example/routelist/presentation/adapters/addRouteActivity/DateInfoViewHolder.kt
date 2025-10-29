package com.example.routelist.presentation.adapters.addRouteActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemInputDateBinding
import com.example.routelist.presentation.adapters.addRouteActivity.model.AddRouteListItem

class DateInfoViewHolder(
    private val binding: ItemInputDateBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.DateRow){
        binding.etDateTime.setText(item.title.toString())
    }
}