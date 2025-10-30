package com.example.routelist.presentation.adapters.mainActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemStatisticCardBinding
import com.example.routelist.presentation.adapters.mainActivity.model.RouteListItem

class CardViewHolder(private val binding: ItemStatisticCardBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RouteListItem.Card) {
        binding.tvTitle.text = item.title
        binding.tvValue.text = item.value
    }
}