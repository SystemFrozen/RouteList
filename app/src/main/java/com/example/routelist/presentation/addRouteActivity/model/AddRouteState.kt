package com.example.routelist.presentation.addRouteActivity.model

data class AddRouteState(
    val routeNumber: RouteNumber = RouteNumber(),
    val dateRow: DateRow = DateRow(),
    val trainInfo: TrainInfo = TrainInfo(),
    val passengerInfo: PassengerInfo = PassengerInfo()
)

