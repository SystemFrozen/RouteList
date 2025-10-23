package com.example.routelist.data.repository

import com.example.routelist.data.database.RouteInfoDao
import com.example.routelist.data.mapper.RouteMapper
import com.example.routelist.domain.RouteListInfo
import com.example.routelist.domain.RouteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RouteRepositoryImpl(
    private val mapper: RouteMapper,
    private val routeInfoDao: RouteInfoDao
) : RouteRepository {

    override fun getAllRoutes(): Flow<List<RouteListInfo>> =
        routeInfoDao.getAllRoutesFlow().map { list ->
            list.map { mapper.mapDbModelToEntity(it) }
        }

    override suspend fun insertRoute(route: RouteListInfo) {
        routeInfoDao.insertRoute(mapper.mapEntityToDbModel(route))
    }

    override suspend fun deleteRoute(route: RouteListInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun clearAll() {
        TODO("Not yet implemented")
    }
}