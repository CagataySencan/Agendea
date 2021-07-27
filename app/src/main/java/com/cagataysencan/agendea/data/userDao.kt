package com.cagataysencan.agendea.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cagataysencan.agendea.models.userInfo

@Dao
interface userDao {
    @Insert()
     fun addUser(user : userInfo)

    @Query("SELECT * FROM userInfo  ORDER BY id ")
    fun readData() :List<userInfo>

}