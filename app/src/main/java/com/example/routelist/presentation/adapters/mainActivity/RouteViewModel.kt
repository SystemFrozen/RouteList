package com.example.routelist.presentation.adapters.mainActivity

import androidx.lifecycle.ViewModel
import com.example.routelist.domain.GetRouteInfoListUseCase
import com.example.routelist.domain.GetRouteInfoUseCase
//import com.example.routelist.domain.LoadDataUseCase
import javax.inject.Inject

class RouteViewModel @Inject constructor(
    private val getRouteInfoListUseCase: GetRouteInfoListUseCase,
    private val getRouteInfoUseCase: GetRouteInfoUseCase,
//    private val loadDataUseCase: LoadDataUseCase
): ViewModel() {

    val routeInfoList = getRouteInfoListUseCase

    fun getDetailInfo(id: Int) = getRouteInfoUseCase(id)

//    init{
//        loadDataUseCase()
//    }
}