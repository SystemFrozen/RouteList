package com.example.routelist.presentation.addRouteActivity


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routelist.domain.InsertRouteUseCase
import com.example.routelist.domain.RouteListInfo
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class AddRouteViewModel @Inject constructor(
    private val insertRouteUseCase: InsertRouteUseCase
) : ViewModel() {


    val items = MutableStateFlow(
        mutableListOf(
            AddRouteListItem.RouteNumber(""),
            AddRouteListItem.DateRow("", "", ""),
            AddRouteListItem.TrainInfo("", 0, "", "", "", "", 0),
            AddRouteListItem.PassengerInfo("", "", "")
        )
    )

    fun updateItem(index: Int, newItem: AddRouteListItem) {
        val list = items.value.toMutableList()
        list[index] = newItem
        items.value = list
    }

    fun saveRoute() {
        val list = items.value

        val route = RouteListInfo(
            routeNumber = (list[0] as AddRouteListItem.RouteNumber).number,
            startDate = (list[1] as AddRouteListItem.DateRow).startDate,
            endDate = (list[1] as AddRouteListItem.DateRow).endDate,
            trainNumber = (list[2] as AddRouteListItem.TrainInfo).trainNumber,
            axes = (list[2] as AddRouteListItem.TrainInfo).axes,
            length = (list[2] as AddRouteListItem.TrainInfo).length,
            startStation = (list[2] as AddRouteListItem.TrainInfo).startStation,
            endStation = (list[2] as AddRouteListItem.TrainInfo).endStation,
            distance = (list[2] as AddRouteListItem.TrainInfo).distance,
            stopsCount = (list[2] as AddRouteListItem.TrainInfo).stopsCount
        )

        viewModelScope.launch(Dispatchers.IO) {
            insertRouteUseCase(route)
        }
    }
}