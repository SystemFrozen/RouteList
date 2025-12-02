package com.example.routelist.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routes")
data class RouteListDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val routeNumber: String,
    val startDate: String,
    val endDate: String,

    val trainNumber: String,
    val composition: String,
    val startStation: String,
    val endStation: String,
    val distance: String,
    val stopsCount: String,

    val passengerTrainNumber: String?,
    val passengerStartDate: String?,
    val passengerEndDate: String?
)
