package com.example.routelist.presentation.adapters.mainActivity

import android.app.Application
import com.example.routelist.di.DaggerApplicationComponent

class RouteApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }


}