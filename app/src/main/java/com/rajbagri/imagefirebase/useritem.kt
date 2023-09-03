package com.rajbagri.imagefirebase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_item")
data class useritem(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "task")
    var task: String,

    @ColumnInfo(name ="time")
    var time: String
)