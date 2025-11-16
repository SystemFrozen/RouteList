package com.example.routelist.presentation.addRouteActivity.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemTrainDetailsBinding
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem

class TrainInfoViewHolder(
    private val binding: ItemTrainDetailsBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.TrainInfo){
         binding.etTrainNumber.setText(item.trainNumber.toString())
         binding.etAxles.setText(item.axes.toString())
         binding.etLength.setText(item.length.toString())
         binding.etStationFrom.setText(item.startStation.toString())
         binding.etStationTo.setText(item.endStation.toString())
         binding.etDistance.setText(item.distance.toString())
         binding.etStops.setText(item.stopsCount.toString())
    }
}