package com.example.routelist.presentation.addRouteActivity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemInputDateBinding
import com.example.routelist.databinding.ItemInputRouteBinding
import com.example.routelist.databinding.ItemPassengerRouteBinding
import com.example.routelist.databinding.ItemTrainDetailsBinding
import com.example.routelist.presentation.addRouteActivity.AddRouteViewModel
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter

class AddRouteAdapter(
    private val router: CalendarPickerRouter,
    private val viewModel: AddRouteViewModel,
) : ListAdapter<AddRouteListItem, RecyclerView.ViewHolder>(AddRouteInfoDiffCallback()) {

    fun populate(items: List<AddRouteListItem>) {
        submitList(items)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val onChange: (Int, AddRouteListItem) -> Unit = { pos, newItem ->
            //viewModel.updateItem(pos, newItem)
        }

        return when (viewType) {

            ROUTE_NUMBER -> RouteNumberViewHolder(
                ItemInputRouteBinding.inflate(inflater, parent, false),
                { _, item -> viewModel.updateRoute(item) }
            )


            DATE_INFO -> DateInfoViewHolder(
                ItemInputDateBinding.inflate(inflater, parent, false),
                router,
                onChange
            )

            TRAIN_INFO -> TrainInfoViewHolder(
                ItemTrainDetailsBinding.inflate(inflater, parent, false),
                onChange
            )

            PASSENGER_INFO -> PassengerInfoViewHolder(
                ItemPassengerRouteBinding.inflate(inflater, parent, false),
                router,
                onChange
            )

            else -> throw IllegalStateException("Unknown viewType")
        }

    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (val item = getItem(position)) {
            is AddRouteListItem.RouteNumber -> (holder as RouteNumberViewHolder).bind(item)
            is AddRouteListItem.DateRow -> (holder as DateInfoViewHolder).bind(item)
            is AddRouteListItem.TrainInfo -> (holder as TrainInfoViewHolder).bind(item)
            is AddRouteListItem.PassengerInfo -> (holder as PassengerInfoViewHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is AddRouteListItem.RouteNumber -> ROUTE_NUMBER
        is AddRouteListItem.DateRow -> DATE_INFO
        is AddRouteListItem.TrainInfo -> TRAIN_INFO
        is AddRouteListItem.PassengerInfo -> PASSENGER_INFO
    }

    companion object {
        internal const val ROUTE_NUMBER = 0
        internal const val DATE_INFO = 1
        internal const val TRAIN_INFO = 2
        internal const val PASSENGER_INFO = 3
    }

}