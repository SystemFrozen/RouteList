package com.example.routelist.presentation.adapters.addRouteActivity

sealed class AddRouteListItem {
    object RouteNumber : AddRouteListItem()
    object WorkPeriod : AddRouteListItem()
    object AdditionalInfo : AddRouteListItem()
    object PassengerFollowing : AddRouteListItem()
}