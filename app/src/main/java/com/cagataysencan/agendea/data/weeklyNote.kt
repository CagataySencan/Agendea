package com.cagataysencan.agendea.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesWeek")
data class weeklyNote(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "date")
    val date : String,
    @ColumnInfo(name = "day")
    val day : String,
    @ColumnInfo(name = "hour")
    var hour : Int,
    @ColumnInfo(name = "time")
    var exactTime : String,
    @ColumnInfo(name = "note")
    var note : String
)
