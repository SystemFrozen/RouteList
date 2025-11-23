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
            endDate = info.endDate,
            yearMonth = info.yearMonth,
            trainNumber = info.trainNumber,
            composition = info.composition,
            startStation = info.startStation,
            endStation = info.endStation,
            distance = info.distance,
            stopsCount = info.stopsCount,
            passengerTrainNumber = info.passengerTrainNumber,
            passengerStartDate = info.passengerStartDate,
            passengerEndDate = info.passengerEndDate
        )
    }

    fun mapDbToInfo(db: RouteListDbModel): RouteListInfo {
        return RouteListInfo(
            id = db.id,
            routeNumber = db.routeNumber,
            startDate = db.startDate,
            endDate = db.endDate,
            yearMonth = db.yearMonth,
            trainNumber = db.trainNumber,
            composition = db.composition,
            startStation = db.startStation,
            endStation = db.endStation,
            distance = db.distance,
            stopsCount = db.stopsCount,
            passengerTrainNumber = db.passengerTrainNumber,
            passengerStartDate = db.passengerStartDate,
            passengerEndDate = db.passengerEndDate
        )
    }
}