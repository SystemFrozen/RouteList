package com.example.routelist.presentation.addRouteActivity


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routelist.domain.InsertRouteUseCase
import com.example.routelist.presentation.addRouteActivity.model.AddRouteState
import com.example.routelist.presentation.addRouteActivity.model.DateRow
import com.example.routelist.presentation.addRouteActivity.model.PassengerInfo
import com.example.routelist.presentation.addRouteActivity.model.RouteNumber
import com.example.routelist.presentation.addRouteActivity.model.TrainInfo
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
        state.value = state.value.copy(
            dateRow = DateRow(
                startDate = start
            )
        )
    }

    fun updateEndDateRow(end: String) {
        state.value = state.value.copy(
            dateRow = DateRow(
                endDate = end
            )
        )
    }


    fun updateTrainInfo(
        trainNumber: String,
        carriageCount: String,
        startStation: String,
        endStation: String,
        distance: String,
        stopsCount: String
    ) {
        state.value = state.value.copy(
            trainInfo = TrainInfo(
                trainNumber,
                carriageCount,
                startStation,
                endStation,
                distance,
                stopsCount
            )
        )
    }

    fun passengerInfo(number: String, start: String, end: String) {
        state.value = state.value.copy(
            passengerInfo = PassengerInfo(
                number,
                start,
                end
            )
        )
    }

    fun updatePassengerStartDateRow(start: String) {
        state.value = state.value.copy(
            passengerInfo = PassengerInfo(
                passengerStartDate = start
            )
        )
    }

    fun updatePassengerEndDateRow(end: String) {
        state.value = state.value.copy(
            passengerInfo = PassengerInfo(
                passengerEndDate = end
            )
        )
    }

    fun saveRoute() {
        viewModelScope.launch {

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
        return false
    }


}