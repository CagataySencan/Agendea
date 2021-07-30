package com.cagataysencan.agendea.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "notes")
data class noteInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "date")
    val date : String,
    @ColumnInfo(name = "note")
    val note : String)
{

}
