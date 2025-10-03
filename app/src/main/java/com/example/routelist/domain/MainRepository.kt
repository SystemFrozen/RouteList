package com.example.routelist.domain

interface MainRepository {

    fun getCards(): List<CardInfo>

    fun getRoutes(): List<Route>
}