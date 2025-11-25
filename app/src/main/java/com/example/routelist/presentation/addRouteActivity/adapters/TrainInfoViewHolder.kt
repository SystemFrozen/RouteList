//package com.example.routelist.presentation.addRouteActivity.adapters
//
//import androidx.recyclerview.widget.RecyclerView
//import com.example.routelist.databinding.ItemTrainDetailsBinding
//import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
//
//class TrainInfoViewHolder(
//    private val binding: ItemTrainDetailsBinding,
//     private val onChange: (Int, AddRouteListItem) -> Unit
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(item: AddRouteListItem.TrainInfo) {
//
//
//        binding.etTrainNumber.setText(item.trainNumber)
//        binding.etComposition.setText(item.composition.toString())
//        binding.etStationFrom.setText(item.startStation.toString())
//        binding.etStationTo.setText(item.endStation)
//        binding.etDistance.setText(item.distance)
//        binding.etStops.setText(item.stopsCount.toString())
//
//        //Короче, я добавлял здесь copy, но суть проблемы в том, что данные все равно не появлялись
//    }
//}