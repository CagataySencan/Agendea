package com.cagataysencan.agendea.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo")
data class userInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name ="name")
    val name : String,
    @ColumnInfo(name = "age")
    val age : String,
    @ColumnInfo(name = "city")
    val city : String) {





}