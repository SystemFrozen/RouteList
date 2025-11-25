package com.example.routelist.presentation.addRouteActivity


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routelist.domain.InsertRouteUseCase
import com.example.routelist.domain.RouteListInfo
import com.example.routelist.presentation.addRouteActivity.model.AddRouteListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class AddRouteViewModel @Inject constructor(
    private val insertRouteUseCase: InsertRouteUseCase
) : ViewModel() {

    // Потом стейт сделаешь при рефаче

    val errorFlow = MutableSharedFlow<String>()

    val items = MutableStateFlow(
        mutableListOf(
            AddRouteListItem.RouteNumber(""),
            AddRouteListItem.DateRow("", "", ""),
            AddRouteListItem.TrainInfo("", "", "", "", "", ""),
            AddRouteListItem.PassengerInfo("", "", "")
        )
    )


    fun updateItem(index: Int, newItem: AddRouteListItem) {
        val list = items.value.toMutableList()
        list[index] = newItem
        items.value = list
    }

    fun updateRoute(newItem: AddRouteListItem) {
        val list = items.value.toMutableList()
        list[0] = newItem
        items.value = list
    }

    fun updateTrain(newItem: AddRouteListItem) {
        val list = items.value.toMutableList()
        list[2] = newItem
        items.value = list
    }


    fun saveRoute() {
        viewModelScope.launch {
            val list = items.value

            val num = (list[0] as AddRouteListItem.RouteNumber)
            val date = (list[1] as AddRouteListItem.DateRow)
            val train = (list[2] as AddRouteListItem.TrainInfo)

            val error = when {
                num.number.isEmpty() -> "Введите номер маршрута"
                date.startDate.isEmpty() -> "Введите время отправления"
                date.endDate.isEmpty() -> "Введите время прибытия"
                !isValidDate(date.startDate) -> "Неверная дата отправления"
                !isValidDate(date.endDate) -> "Неверная дата прибытия"
                parse(date.startDate)!! >= parse(date.endDate)!! -> "Прибытие должно быть позже отправления"
                train.trainNumber.trim().isEmpty() -> "Введите номер поезда"
                train.startStation.trim().isEmpty() && train.endStation.trim()
                    .isEmpty() -> "Укажите станции"

                train.distance.trim().isEmpty() -> "Введите дистанцию"
                train.distance.toDoubleOrNull() == null -> "Дистанция — только цифры"
                else -> null

            }
            if (error != null) {
                errorFlow.emit(error)
                return@launch
            }
            withContext(Dispatchers.IO) {
                insertRouteUseCase(
                    RouteListInfo(
                        routeNumber = num.number,
                        startDate = date.startDate,
                        endDate = date.endDate,
                        yearMonth = date.startDate.substring(
                            6,
                            10
                        ) + "-" + date.startDate.substring(3, 5),
                        trainNumber = train.trainNumber.trim(),
                        composition = train.composition.trim(),
                        startStation = train.startStation.trim(),
                        endStation = train.endStation.trim(),
                        distance = train.distance.trim(),
                        stopsCount = train.stopsCount.trim(),
                        passengerTrainNumber = (list.getOrNull(3) as? AddRouteListItem.PassengerInfo)?.passengerTrainNumber?.trim(),
                        passengerStartDate = (list.getOrNull(3) as? AddRouteListItem.PassengerInfo)?.passengerStartDate,
                        passengerEndDate = (list.getOrNull(3) as? AddRouteListItem.PassengerInfo)?.passengerEndDate
                    )
                )
            }
        }
    }

    private fun isValidDate(s: String) = parse(s) != null

    private fun parse(s: String) = try {
        LocalDateTime.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
    } catch (e: Exception) {
        null
    }

    fun validate() {
        viewModelScope.launch {
            if (!items.value.all { it.isValid() }) errorFlow.emit("Заполните все поля")
        }
    }
}