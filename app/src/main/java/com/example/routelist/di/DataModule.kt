//package com.example.routelist.di
//
//import android.content.Context
//import androidx.room.Room
//import com.example.routelist.data.database.AppDatabase
//import com.example.routelist.data.database.RouteInfoDao
//import com.example.routelist.data.mapper.RouteMapper
//import com.example.routelist.data.repository.RouteRepositoryImpl
//import com.example.routelist.domain.RouteRepository
//import dagger.Module
//import dagger.Provides
//import javax.inject.Singleton
//
//@Module
//interface DataModule {
//
//    @Provides
//    @Singleton
//    fun provideDatabase(context: Context): AppDatabase =
//        Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            "main.db"
//        ).build()
//
//    @Provides
//    fun provideRouteDao(database: AppDatabase): RouteInfoDao =
//        database.routeInfoDao()
//
//    @Provides
//    @Singleton
//    fun provideMapper(): RouteMapper = RouteMapper()
//
//    @Provides
//    @Singleton
//    fun provideRouteRepository(
//        mapper: RouteMapper,
//        routeInfoDao: RouteInfoDao
//
//    ): RouteRepository = RouteRepositoryImpl(mapper, routeInfoDao)
//}