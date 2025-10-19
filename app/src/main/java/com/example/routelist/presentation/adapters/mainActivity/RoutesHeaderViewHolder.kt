package com.example.routelist.presentation.adapters.mainActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemRoutesHeaderBinding

class RoutesHeaderViewHolder(private val binding: ItemRoutesHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.tvRoutesHeader.text = "Маршрутные листы"
    }


}