package com.example.routelist.presentation.adapters.mainActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemRouteBinding

class RouteViewHolder(private val binding: ItemRouteBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RouteListItem.RouteItem) {
        binding.tvTrain.text = item.trainNumber
        binding.tvStart.text = item.start
        binding.tvEnd.text = item.end
        binding.tvHours.text = item.hours
        binding.cardViewMaterial.shapeAppearanceModel = item.routePosition.shapeAppearanceModel
    }

}