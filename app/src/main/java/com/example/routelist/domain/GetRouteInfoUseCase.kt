package com.example.routelist.domain

import javax.inject.Inject

class GetRouteInfoUseCase @Inject constructor(
    private val repository: RouteRepository
) {

    operator fun invoke(id: Int) = repository.getRouteInfo(id)

}