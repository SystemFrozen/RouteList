package com.example.routelist.presentation.addRouteActivity


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routelist.domain.InsertRouteUseCase
import com.example.routelist.domain.RouteListInfo
import com.example.routelist.presentation.addRouteActivity.model.AddRouteState
import com.example.routelist.presentation.addRouteActivity.model.RouteNumber
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class AddRouteViewModel @Inject constructor(
    private val insertRouteUseCase: InsertRouteUseCase
) : ViewModel() {

    private val state = MutableStateFlow(AddRouteState())

    private val errorFlow = MutableSharedFlow<String>()


    fun updateRouteNumber(number: String) {
        state.value = state.value.copy(routeNumber = RouteNumber(number))
    }

    fun updateStartDateRow(start: String) {
        val current = state.value
        state.value = current.copy(
            dateRow = current.dateRow.copy(startDate = start)
        )
    }

    fun updateEndDateRow(end: String) {
        val current = state.value
        state.value = current.copy(
            dateRow = current.dateRow.copy(endDate = end)
        )
    }

    fun updateTrainNumber(trainNum: String) {
        val current = state.value
        state.value = current.copy(
            trainInfo = current.trainInfo.copy(trainNumber = trainNum)
        )
    }

    fun updateCarriageCount(carriageCount: String) {
        val current = state.value
        state.value = current.copy(
            trainInfo = current.trainInfo.copy(carriageCount = carriageCount)
        )
    }

    fun updateStartStation(startStation: String) {
        val current = state.value
        state.value = current.copy(
            trainInfo = current.trainInfo.copy(startStation = startStation)
        )
    }

    fun updateEndStation(endStation: String) {
        val current = state.value
        state.value = current.copy(
            trainInfo = current.trainInfo.copy(endStation = endStation)
        )
    }

    fun updateDistance(distance: String) {
        val current = state.value
        state.value = current.copy(
            trainInfo = current.trainInfo.copy(distance = distance)
        )
    }

    fun updateCountStop(stopsCount: String) {
        val current = state.value
        state.value = current.copy(
            trainInfo = current.trainInfo.copy(stopsCount = stopsCount)
        )
    }


    fun updatePassengerNumber(number: String) {
        val current = state.value
        state.value = current.copy(
            passengerInfo = current.passengerInfo.copy(passengerTrainNumber = number)
        )
    }

    fun updatePassengerStartDateRow(start: String) {
        val current = state.value
        state.value = current.copy(
            passengerInfo = current.passengerInfo.copy(passengerStartDate = start)
        )
    }

    fun updatePassengerEndDateRow(end: String) {
        val current = state.value
        state.value = current.copy(
            passengerInfo = current.passengerInfo.copy(passengerEndDate = end)
        )
    }

    fun saveRoute() {
        viewModelScope.launch {
            val save = state.value

            val entity = RouteListInfo(
                routeNumber = save.routeNumber.number.toString(),
                startDate = save.dateRow.startDate.toString(),
                endDate = save.dateRow.endDate.toString(),
                trainNumber = save.trainInfo.trainNumber.toString(),
                composition = save.trainInfo.carriageCount.toString(),
                startStation = save.trainInfo.startStation.toString(),
                endStation = save.trainInfo.endStation.toString(),
                distance = save.trainInfo.distance.toString(),
                stopsCount = save.trainInfo.stopsCount.toString(),
                passengerTrainNumber = save.passengerInfo.passengerTrainNumber,
                passengerStartDate = save.passengerInfo.passengerStartDate,
                passengerEndDate = save.passengerInfo.passengerEndDate
            )

            insertRouteUseCase(entity)
        }
    }

    private fun isValidDate(s: String) = parse(s) != null

    private fun parse(s: String) = try {
        LocalDateTime.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
    } catch (e: Exception) {
        null
    }

    fun getStateFlow(): SharedFlow<AddRouteState> {
        return state
    }

    fun getErrorFlow(): SharedFlow<String> {
        return errorFlow
    }

    fun validate(): Boolean {
        val s = state.value

        when {
            s.routeNumber.number.isNullOrBlank() ->
                return error("Введите номер маршрута")

            s.dateRow.startDate.isNullOrBlank() || !isValidDate(s.dateRow.startDate) ->
                return error("Некорректная дата отправления")

            s.dateRow.endDate.isNullOrBlank() || !isValidDate(s.dateRow.endDate) ->
                return error("Некорректная дата прибытия")

            s.trainInfo.trainNumber.isNullOrBlank() ->
                return error("Введите номер поезда")

            s.trainInfo.carriageCount.isNullOrBlank() ->
                return error("Введите количество вагонов")

            s.trainInfo.startStation.isNullOrBlank() ->
                return error("Введите станцию отправления")

            s.trainInfo.endStation.isNullOrBlank() ->
                return error("Введите станцию назначения")
        }


        return true
    }

    private fun error(message: String): Boolean {
        viewModelScope.launch {
            errorFlow.emit(message)
        }

        return false
    }

}