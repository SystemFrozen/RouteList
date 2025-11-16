package com.example.routelist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.routelist.presentation.addRouteActivity.AddRouteViewModel
import com.example.routelist.presentation.mainActivity.RouteViewModel
import com.example.routelist.presentation.mainActivity.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddRouteViewModel::class)
    fun bindAddRouteViewModel(viewModel: AddRouteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RouteViewModel::class)
    fun bindRouteViewModel(viewModel: RouteViewModel): ViewModel
}