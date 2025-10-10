package com.example.routelist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.routelist.domain.GetCardsUseCase
import com.example.routelist.domain.GetRoutesUseCase
import com.example.routelist.presentation.adapters.RouteListItem

class MainViewModel(
) : ViewModel() {
    private val _items = MutableLiveData<List<RouteListItem>>()
    val items: LiveData<List<RouteListItem>> get() = _items

    init {
        loadData()
    }

    private fun loadData() {
        val uiItems = mutableListOf<RouteListItem>()

        // календарь
        uiItems.add(RouteListItem.CalendarHeader("Сентябрь 2025"))

        // карточки
        uiItems.add(RouteListItem.Card("Норма часов", "184"))
        uiItems.add(RouteListItem.Card("Норма на сегодня", "64"))
        uiItems.add(RouteListItem.Card("Всего", "24:00"))
        uiItems.add(RouteListItem.Card("Пассажиром","0:00"))
        uiItems.add(RouteListItem.Card("Ночных", "6:12"))

        // заголовок маршрутов
        uiItems.add(RouteListItem.RoutesHeader)

        // маршруты
        uiItems.add(RouteListItem.RouteItem("123", "01.09 08:00", "01.09 16:00", "8"))
        uiItems.add(RouteListItem.RouteItem("456", "02.09 09:00", "02.09 18:00", "9"))

        _items.value = uiItems
    }
}