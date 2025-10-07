package com.example.routelist.domain

class GetRoutesUseCase (
    private val repository: MainRepository
) {

    operator fun invoke(): List<Route> = repository.getRoutes()
}