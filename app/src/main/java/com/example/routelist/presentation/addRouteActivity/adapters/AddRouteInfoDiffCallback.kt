package com.example.routelist.presentation.addRouteActivity.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem

class AddRouteInfoDiffCallback : DiffUtil.ItemCallback<AddRouteListItem>() {

    override fun areItemsTheSame(
        oldItem: AddRouteListItem,
        newItem: AddRouteListItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: AddRouteListItem,
        newItem: AddRouteListItem
    ): Boolean {
        return true
    }
}