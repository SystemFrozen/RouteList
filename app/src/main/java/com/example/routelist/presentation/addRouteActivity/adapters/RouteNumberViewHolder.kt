//package com.example.routelist.presentation.addRouteActivity.adapters
//
//import androidx.core.widget.addTextChangedListener
//import androidx.recyclerview.widget.RecyclerView
//import com.example.routelist.databinding.ItemInputRouteBinding
//import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
//
//class RouteNumberViewHolder(
//    private val binding: ItemInputRouteBinding,
//    private val onChange: (Int, AddRouteListItem) -> Unit
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(item: AddRouteListItem.RouteNumber) {
//
//        binding.etRouteNumber.setText(item.number)
//
//
//        binding.etRouteNumber.addTextChangedListener {
//            val updated = item.copy(number = it.toString())
//            onChange(bindingAdapterPosition, updated)
//        }
//    }
//}