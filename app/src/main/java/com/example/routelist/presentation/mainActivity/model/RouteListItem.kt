package com.example.routelist.presentation.mainActivity.model

sealed class RouteListItem {

    data class CalendarHeader(val monthYear: String) : RouteListItem()

    object RoutesHeader : RouteListItem()

    data class Card(
        val title: String,
        val value: String
    ) : RouteListItem()

    data class RouteItem(
        val trainNumber: String,
        val start: String,
        val end: String,
        val hours: String,
        val routePosition: RoutePosition,
    ) : RouteListItem()

}