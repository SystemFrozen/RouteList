package com.example.routelist.domain

import javax.inject.Inject

class GetAllRoutesUseCase @Inject constructor(
    private val repository: RouteRepository
) {
    operator fun invoke() = repository.getAllRoutes()
}