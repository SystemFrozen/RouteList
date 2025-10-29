package com.example.routelist.domain

data class RouteListInfo(
    val id: Int = UNDEFINED_ID,
    val routeNumber: String,
    val startDate: String,
    val endDate: String,
    val trainNumber: String,
    val axes: Int,
    val length: String,
    val startStation: String,
    val endStation: String,
    val distance: String,
    val stopsCount: Int
) {

    companion object {
        const val UNDEFINED_ID = 0
    }
}