package com.example.routelist.presentation.addRouteActivity.adapters

import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemTrainDetailsBinding
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem

class TrainInfoViewHolder(
    private val binding: ItemTrainDetailsBinding,
    private val onChange: (Int, AddRouteListItem.TrainInfo) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AddRouteListItem.TrainInfo) {

        binding.etTrainNumber.setText(item.trainNumber)
        binding.etComposition.setText(item.composition)
        binding.etStationFrom.setText(item.startStation)
        binding.etStationTo.setText(item.endStation)
        binding.etDistance.setText(item.distance)
        binding.etStops.setText(item.stopsCount)

        binding.etTrainNumber.addTextChangedListener {
            val updated = item.copy(trainNumber = it.toString())
            onChange(absoluteAdapterPosition, updated)
        }

        binding.etComposition.addTextChangedListener {
            val updated = item.copy(composition = it.toString())
            onChange(absoluteAdapterPosition, updated)
        }

        binding.etStationFrom.addTextChangedListener {
            val updated = item.copy(startStation = it.toString())
            onChange(absoluteAdapterPosition, updated)
        }

        binding.etStationTo.addTextChangedListener {
            val updated = item.copy(endStation = it.toString())
            onChange(absoluteAdapterPosition, updated)
        }

        binding.etDistance.addTextChangedListener {
            val updated = item.copy(distance = it.toString())
            onChange(absoluteAdapterPosition, updated)
        }

        binding.etStops.addTextChangedListener {
            val updated = item.copy(stopsCount = it.toString())
            onChange(absoluteAdapterPosition, updated)
        }
    }
}