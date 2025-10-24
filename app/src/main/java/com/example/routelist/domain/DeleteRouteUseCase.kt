package com.example.routelist.domain

import javax.inject.Inject

class DeleteRouteUseCase @Inject constructor(
    private val repository: RouteRepository
) {
    suspend operator fun invoke(route: RouteListInfo) = repository.deleteRoute(route)
}