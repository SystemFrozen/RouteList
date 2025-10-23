package com.example.routelist.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routes")
data class RouteListDbModel(
    @PrimaryKey(autoGenerate = true)
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
