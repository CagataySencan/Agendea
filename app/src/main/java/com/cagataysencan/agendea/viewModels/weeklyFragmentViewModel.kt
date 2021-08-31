package com.cagataysencan.agendea.viewModels

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.weeklyNote
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import kotlin.math.absoluteValue

class weeklyFragmentViewModel(application: Application) : AndroidViewModel(application) {


    @RequiresApi(Build.VERSION_CODES.O)
    var database : userDatabase = userDatabase.getData(application)
    val weeklyNotes : LiveData<List<weeklyNote>> = database.userDao().readWeeklyNote()
    @RequiresApi(Build.VERSION_CODES.O)
    fun printWeek (context: Context, id : Int, arrayList: ArrayList<weeklyNote>, i : Int, note : String,exactTime : String) {


        val currentDate = LocalDate.now()
        val dayCount = -currentDate.dayOfWeek.getLong(ChronoField.DAY_OF_WEEK)  + i
        val day = currentDate.plusDays(dayCount).dayOfWeek.toString()



        val startOfWeek =currentDate.plusDays(dayCount).format(DateTimeFormatter.ofPattern("dd-MM-yy"))
        var weeklyNoteObject = weeklyNote(id,startOfWeek,day,1,exactTime,note)


        if(database.userDao().checkTable() < 7  ) {
            database.userDao().addWeeklyNote(weeklyNoteObject)
        }
       if(startOfWeek != database.userDao().getDates()[0]) {
            database.userDao().updateWeekly(weeklyNoteObject)


        }

        arrayList.add(weeklyNoteObject)

    }
}