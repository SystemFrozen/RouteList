package com.example.routelist.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.routelist.databinding.ItemHeaderBinding
import com.example.routelist.databinding.ItemRouteBinding
import com.example.routelist.databinding.ItemRoutesHeaderBinding
import com.example.routelist.databinding.ItemStatisticCardBinding

class RouteListAdapter(
    private var items: List<RouteListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val CALENDAR_HEADER = 0
        private const val CARD_INFO = 1
        private const val ROUTES_HEADER = 2
        private const val ROUTE_LIST = 3

    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is RouteListItem.CalendarHeader -> CALENDAR_HEADER
        RouteListItem.RoutesHeader -> ROUTES_HEADER
        is RouteListItem.Card -> CARD_INFO
        is RouteListItem.RouteItem -> ROUTE_LIST
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            CALENDAR_HEADER -> CalendarViewHolder(
                ItemHeaderBinding.inflate(inflater, parent, false)
            )

            CARD_INFO -> CardViewHolder(
                ItemStatisticCardBinding.inflate(inflater, parent, false)
            )

            ROUTES_HEADER -> RoutesHeaderViewHolder(
                ItemRoutesHeaderBinding.inflate(inflater, parent, false)
            )

            ROUTE_LIST -> RouteViewHolder(
                ItemRouteBinding.inflate(inflater, parent, false)
            )

            else -> throw IllegalStateException("Unknown viewType")
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (val item = items[position]) {
            is RouteListItem.CalendarHeader -> (holder as CalendarViewHolder).bind()
            is RouteListItem.Card -> (holder as CardViewHolder).bind(item)
            is RouteListItem.RoutesHeader -> (holder as RoutesHeaderViewHolder).bind()
            is RouteListItem.RouteItem -> (holder as RouteViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size

    fun submitList(newItems: List<RouteListItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}
