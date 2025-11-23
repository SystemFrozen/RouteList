package com.example.routelist.presentation.addRouteActivity.model

sealed class AddRouteListItem {

    data class RouteNumber(val number: String) : AddRouteListItem()

    data class DateRow(
        val dateTime: String?,
        val startDate: String,
        val endDate: String
    ) : AddRouteListItem()

    data class TrainInfo(
        val trainNumber: String,
        val composition: String,
        val startStation: String,
        val endStation: String,
        val distance: String,
        val stopsCount: String
    ) : AddRouteListItem()

    data class PassengerInfo(
        val passengerTrainNumber: String,
        val passengerStartDate: String,
        val passengerEndDate: String
    ) : AddRouteListItem()
}