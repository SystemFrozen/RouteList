package com.example.routelist.domain

data class RouteListInfo(
    val id: Int = 0,
    val routeNumber: String,
    val startDate: String,
    val endTime: String,
    val trainNumber: String,
    val axes: Int,
    val length: String,
    val startStation: String,
    val endStation: String,
    val distance: String,
    val stopsCount: Int
)