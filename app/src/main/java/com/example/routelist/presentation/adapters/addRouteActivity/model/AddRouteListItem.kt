package com.example.routelist.presentation.adapters.addRouteActivity.model

sealed class AddRouteListItem {

    data class RouteNumber(val number: String) : AddRouteListItem()

    data class DateRow(
        val title: String,
        val dateTime: String
    ) : AddRouteListItem()

    data class TrainInfo(
        val trainNumber: String,
        val axes: Int,
        val length: String,
        val startStation: String,
        val endStation: String,
        val distance: String,
        val stopsCount: Int
    ): AddRouteListItem()

    data class PassengerInfo(
        val trainNumber: String,
        val startDate: String,
        val endDate: String
    ): AddRouteListItem()
}