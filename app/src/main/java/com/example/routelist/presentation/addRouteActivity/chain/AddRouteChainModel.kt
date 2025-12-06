package com.example.routelist.presentation.addRouteActivity.chain

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

sealed interface AddRouteChainModel {

    fun isValid(): Boolean

    abstract class OnlyString(val text: String?, val errorText: String) : AddRouteChainModel {

        override fun isValid() = text.isNullOrBlank()
    }

    class Number(number: String?) : OnlyString(number, "Введите номер маршрута")

    class TrainNumber(trainNumber: String?) : OnlyString(trainNumber, "Введите номер поезда")

    class CarriageCount(carriageCount: String?) : OnlyString(carriageCount, "Введите номер поезда")

    class StartStation(startStation: String?) : OnlyString(startStation, "Введите станцию отправления")

    class EndStation(endStation: String?) : OnlyString(endStation, "Введите станцию назначения")

    data class Date(val startDate: String?) : AddRouteChainModel {

        override fun isValid(): Boolean {
            return startDate.isNullOrBlank() || dateToPattern(startDate) == null
        }

        private fun dateToPattern(s: String) = try {
            LocalDateTime.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
        } catch (e: Exception) {
            null
        }
    }


}