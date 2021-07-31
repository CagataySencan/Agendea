package com.cagataysencan.agendea.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*


@Entity(tableName = "notes")
data class noteInfo(

    @PrimaryKey(autoGenerate =false)
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time : Int,
    @ColumnInfo(name ="exactTime")
    val exactTime : String,
    @ColumnInfo(name = "note")
    val note: String)
{

}
