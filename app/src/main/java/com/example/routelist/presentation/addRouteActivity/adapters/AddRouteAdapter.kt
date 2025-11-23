package com.example.routelist.presentation.addRouteActivity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemInputDateBinding
import com.example.routelist.databinding.ItemInputRouteBinding
import com.example.routelist.databinding.ItemPassengerRouteBinding
import com.example.routelist.databinding.ItemTrainDetailsBinding
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import com.example.routelist.presentation.addRouteActivity.model.CalendarPickerRouter

class AddRouteAdapter(
    private val items: MutableList<AddRouteListItem>,
    private val router: CalendarPickerRouter
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {

            ROUTE_NUMBER -> RouteNumberViewHolder(
                ItemInputRouteBinding.inflate(inflater, parent, false)
            ) { pos, newItem ->
                updateItem(pos, newItem)
            }


            DATE_INFO -> DateInfoViewHolder(
                ItemInputDateBinding.inflate(inflater, parent, false),
                router
            ) { pos, newItem ->
                updateItem(pos, newItem)
            }

            TRAIN_INFO -> TrainInfoViewHolder(
                ItemTrainDetailsBinding.inflate(inflater, parent, false)
            ){pos, newItem ->
                updateItem(pos,newItem)

            }

            PASSENGER_INFO -> PassengerInfoViewHolder(
                ItemPassengerRouteBinding.inflate(inflater, parent, false),
                router
            ) { pos, newItem ->

                updateItem(pos, newItem)
            }

            else -> throw IllegalStateException("Unknown viewType")
        }

    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (val item = items[position]) {
            is AddRouteListItem.RouteNumber -> (holder as RouteNumberViewHolder).bind(item)
            is AddRouteListItem.DateRow -> (holder as DateInfoViewHolder).bind(item)
            is AddRouteListItem.TrainInfo -> (holder as TrainInfoViewHolder).bind(item)
            is AddRouteListItem.PassengerInfo -> (holder as PassengerInfoViewHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is AddRouteListItem.RouteNumber -> ROUTE_NUMBER
        is AddRouteListItem.DateRow -> DATE_INFO
        is AddRouteListItem.TrainInfo -> TRAIN_INFO
        is AddRouteListItem.PassengerInfo -> PASSENGER_INFO
    }

    override fun getItemCount() = items.size

    fun getItems(): List<AddRouteListItem> = items

    // типо notify
    fun updateItem(position: Int, newItem: AddRouteListItem) {
        if (position != RecyclerView.NO_POSITION) {
            items[position] = newItem
        }
    }


    companion object {
        internal const val ROUTE_NUMBER = 0
        internal const val DATE_INFO = 1
        internal const val TRAIN_INFO = 2
        internal const val PASSENGER_INFO = 3
    }

}