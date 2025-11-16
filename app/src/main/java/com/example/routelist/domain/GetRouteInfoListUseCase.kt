package com.example.routelist.domain

import javax.inject.Inject

class GetRouteInfoListUseCase @Inject constructor(
    private val repository: RouteRepository,

) {
    operator fun invoke() = repository.getRouteInfoList()
}