package com.example.routelist.domain

class GetCardsUseCase (
    private val repository: MainRepository
) {

    operator fun invoke(): List<CardInfo> = repository.getCards()
}