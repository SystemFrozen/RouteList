package com.example.routelist.domain

import kotlinx.coroutines.flow.Flow

interface RouteRepository {

    fun getAllRoutes(): Flow<List<RouteListInfo>>

    suspend fun insertRoute(route: RouteListInfo)

    suspend fun deleteRoute(route: RouteListInfo)

    suspend fun clearAll()

}