package com.example.routelist.di

import android.app.Application
import com.example.routelist.presentation.adapters.addRouteActivity.AddRouteFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(fragment: AddRouteFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}