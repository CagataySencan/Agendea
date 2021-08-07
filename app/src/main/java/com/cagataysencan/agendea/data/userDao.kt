package com.cagataysencan.agendea.data

import androidx.room.*

@Dao
interface userDao {
    @Insert()
    fun addUser(user : userInfo)

    @Insert()
    fun addNote(note : noteInfo)

    @Delete()
    fun deleteNote(model: noteInfo)

    @Query("SELECT * FROM userInfo  ORDER BY id ")
    fun readData() :List<userInfo>

    @Query("SELECT * FROM notes  ORDER BY time ")
    fun readNote() : List<noteInfo>





}