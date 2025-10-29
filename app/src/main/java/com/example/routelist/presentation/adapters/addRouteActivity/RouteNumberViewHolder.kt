package com.example.routelist.presentation.adapters.addRouteActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemInputRouteBinding
import com.example.routelist.presentation.adapters.addRouteActivity.model.AddRouteListItem

class RouteNumberViewHolder(
    private val binding: ItemInputRouteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.RouteNumber) {
        binding.etRouteNumber.setText(item.number.toString())
    }
}