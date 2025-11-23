package com.example.routelist.domain

data class RouteListInfo(
    val id: Int = 0,
    val routeNumber: String,
    val startDate: String,
    val endDate: String,
    val yearMonth: String,
    val trainNumber: String,
    val composition: String,
    val startStation: String,
    val endStation: String,
    val distance: String,
    val stopsCount: String,
    val passengerTrainNumber: String? = null,
    val passengerStartDate: String? = null,
    val passengerEndDate: String? = null
)