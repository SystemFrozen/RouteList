package com.example.routelist.data.mapper

import com.example.routelist.data.database.RouteListDbModel
import com.example.routelist.domain.RouteListInfo
import javax.inject.Inject

class RouteMapper @Inject constructor() {

    fun mapDbModelToEntity(db: RouteListDbModel): RouteListInfo = RouteListInfo(
        id = db.id,
        routeNumber = db.routeNumber,
        startDate = db.startDate,
        endTime = db.endTime,
        trainNumber = db.trainNumber,
        axes = db.axes,
        length = db.length,
        startStation = db.startStation,
        endStation = db.endStation,
        distance = db.distance,
        stopsCount = db.stopsCount
    )

    fun mapEntityToDbModel(entity: RouteListInfo): RouteListDbModel = RouteListDbModel (
        id = entity.id,
        routeNumber = entity.routeNumber,
        startDate = entity.startDate,
        endTime = entity.endTime,
        trainNumber = entity.trainNumber,
        axes = entity.axes,
        length = entity.length,
        startStation = entity.startStation,
        endStation = entity.endStation,
        distance = entity.distance,
        stopsCount = entity.stopsCount
    )
}