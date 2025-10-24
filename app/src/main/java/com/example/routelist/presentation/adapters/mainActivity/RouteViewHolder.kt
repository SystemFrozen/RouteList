package com.example.routelist.presentation.adapters.mainActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemRouteBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.ShapeAppearanceModel

class RouteViewHolder(private val binding: ItemRouteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RouteListItem.RouteItem) {
        binding.tvTrain.text = item.trainNumber
        binding.tvStart.text = item.start
        binding.tvEnd.text = item.end
        binding.tvHours.text = item.hours

        var shapeAppearanceModel: ShapeAppearanceModel.Builder = ShapeAppearanceModel().toBuilder()
        shapeAppearanceModel.setBottomRightCorner(
            CornerFamily.ROUNDED,
            CornerSize { return@CornerSize 45F })
        binding.cardViewMaterial.shapeAppearanceModel = shapeAppearanceModel.build()
    }

}