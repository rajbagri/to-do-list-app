package com.rajbagri.imagefirebase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface UserDao {

    @Upsert
    suspend fun upsert(item: useritem)

    @Delete
    suspend fun delete(item: useritem)

    @Query("Select * from user_item")
    fun getItemInfo(): LiveData<List<useritem>>
}