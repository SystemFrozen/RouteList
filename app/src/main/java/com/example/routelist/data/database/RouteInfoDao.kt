package com.example.routelist.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RouteInfoDao {

    @Query("SELECT * FROM routes ORDER BY id DESC")
    fun getAllRoutesFlow(): Flow<List<RouteListDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoute(route: RouteListDbModel)

    @Delete
    fun deleteRoute(route: RouteListDbModel)

}