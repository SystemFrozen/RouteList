package com.example.routelist.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRouteInfoListUseCase @Inject constructor(
    private val repository: RouteRepository,

) {
    operator fun invoke(): Flow<List<RouteListInfo>> = repository.getRouteInfoList()
}