package com.example.routelist.domain

import javax.inject.Inject

class ClearAllUseCase @Inject constructor(
    private val repository: RouteRepository
) {
    suspend operator fun invoke() = repository.clearAll()
}