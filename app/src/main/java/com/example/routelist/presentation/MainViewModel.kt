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
        uiItems.add(RouteListItem.Card("Норма часов", "160"))
        uiItems.add(RouteListItem.Card("Отработано", "120"))
        uiItems.add(RouteListItem.Card("Зарплата", "50 000"))
        uiItems.add(RouteListItem.Card("Премия", "10 000"))

        // заголовок маршрутов
        uiItems.add(RouteListItem.RoutesHeader)

        // маршруты
        uiItems.add(RouteListItem.RouteItem("123", "01.09 08:00", "01.09 16:00", "8"))
        uiItems.add(RouteListItem.RouteItem("456", "02.09 09:00", "02.09 18:00", "9"))

        _items.value = uiItems
    }
}