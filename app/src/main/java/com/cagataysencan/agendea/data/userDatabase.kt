package com.cagataysencan.agendea.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [userInfo::class, noteInfo::class,weeklyNote::class],version = 2,exportSchema = false)

abstract class userDatabase : RoomDatabase() {

    abstract fun userDao() : userDao

    companion object{
        @Volatile
        private var INSTANCE : userDatabase? = null


        fun getData(context: Context): userDatabase {


            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    userDatabase::class.java,
                    "userInfo"

                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }

        }
    }
}