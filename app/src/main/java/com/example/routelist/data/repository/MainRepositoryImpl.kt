package com.example.routelist.data.repository

import com.example.routelist.domain.CardInfo
import com.example.routelist.domain.MainRepository
import com.example.routelist.domain.Route

class MainRepositoryImpl : MainRepository {

    override fun getCards(): List<CardInfo> {
        return listOf(
            CardInfo("Норма часов", "160"),
            CardInfo("Норма на сегодня", "120"),
            CardInfo("Отработано", "7:00"),
            CardInfo("Ночные", "0:00")
        )
    }


    override fun getRoutes(): List<Route> {
        return listOf(
            Route(1, "08:00", "18:00", 10),
            Route(2, "09:00", "17:00", 8)
        )
    }
}