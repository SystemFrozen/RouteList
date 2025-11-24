package com.example.routelist.presentation.addRouteActivity.model

sealed class AddRouteListItem {

    abstract fun isValid(): Boolean

    data class RouteNumber(val number: String) : AddRouteListItem() {

        override fun isValid(): Boolean = number.isNotEmpty()
    }

    data class DateRow(
        val dateTime: String?,
        val startDate: String,
        val endDate: String
    ) : AddRouteListItem() {

        override fun isValid(): Boolean {
            return true //э, тут
        }
    }

    data class TrainInfo(
        val trainNumber: String,
        val composition: String,
        val startStation: String,
        val endStation: String,
        val distance: String,
        val stopsCount: String
    ) : AddRouteListItem() {

        override fun isValid(): Boolean {
            return true
        }
    }

    data class PassengerInfo(
        val passengerTrainNumber: String,
        val passengerStartDate: String,
        val passengerEndDate: String
    ) : AddRouteListItem() {

        override fun isValid(): Boolean {
            return true
        }
    }
}