package com.cagataysencan.agendea.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface userDao {
    @Insert()
    fun addUser(user : userInfo)

    @Insert()
    fun addNote(today : todayInfo)

    @Insert
    fun addWeeklyNote(note : weeklyNote)

    @Delete()
    fun deleteNote(model: todayInfo)

    @Update()
    fun deleteWeeklyNote(model : weeklyNote)

    @Update()
    fun updateWeekly(model : weeklyNote)


    @Query("SELECT * FROM userInfo  ORDER BY id ")
    fun readData() :List<userInfo>

    @Query("SELECT * FROM notesToday  ORDER BY time ")
    fun readNote() : LiveData<List<todayInfo>>

    @Query("SELECT * FROM notesWeek ORDER BY id")
    fun readWeeklyNote() : LiveData<List<weeklyNote>>

    @Query("SELECT COUNT('id') FROM notesWeek")

    fun checkTable() : Int

    @Query("SELECT date FROM notesWeek")
    fun getDates() : List<String>

    @Query("SELECT note FROM notesWeek ")
    fun getNote() : List<String>

    @Query("SELECT time FROM notesWeek ")
    fun getTime() : List<String>

    @Query("SELECT * FROM notesMonth ORDER BY id")
    fun readMonthlyNote() : LiveData<List<monthlyNote>>





}