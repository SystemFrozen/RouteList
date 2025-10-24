package com.example.routelist.domain

import javax.inject.Inject

class InsertRouteUseCase @Inject constructor(
    private val repository: RouteRepository
) {
    suspend operator fun invoke(route: RouteListInfo) = repository.insertRoute(route)
}