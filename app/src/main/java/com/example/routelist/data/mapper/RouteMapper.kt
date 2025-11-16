package com.example.routelist.data.mapper

import com.example.routelist.data.database.RouteListDbModel
import com.example.routelist.domain.RouteListInfo
import javax.inject.Inject

class RouteMapper @Inject constructor() {

    fun mapInfoToDb(info: RouteListInfo): RouteListDbModel {
        return RouteListDbModel(
            id = info.id,
            routeNumber = info.routeNumber,
            startDate = info.startDate,
            endTime = info.endDate,
            trainNumber = info.trainNumber,
            axes = info.axes,
            length = info.length,
            startStation = info.startStation,
            endStation = info.endStation,
            distance = info.distance,
            stopsCount = info.stopsCount
        )
    }

    fun mapDbToInfo(db: RouteListDbModel): RouteListInfo {
        return RouteListInfo(
            id = db.id,
            routeNumber = db.routeNumber,
            startDate = db.startDate,
            endDate = db.endTime,
            trainNumber = db.trainNumber,
            axes = db.axes,
            length = db.length,
            startStation = db.startStation,
            endStation = db.endStation,
            distance = db.distance,
            stopsCount = db.stopsCount
        )
    }
}