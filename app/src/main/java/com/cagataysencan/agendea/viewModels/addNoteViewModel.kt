package com.cagataysencan.agendea.viewModels

import android.app.Application
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.todayInfo
import com.cagataysencan.agendea.data.weeklyNote
import com.cagataysencan.agendea.views.MainActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.util.*

class addNoteViewModel(application: Application) : AndroidViewModel(application) {
    fun fragmentChanger(fragment: Fragment, context: Context)   {
        var transaction = (context as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()
    }

     fun update(showDate: TextView, calendar: Calendar) {
        val format = SimpleDateFormat("dd-MM-yyyy", Locale.US).format(calendar.time)
        showDate.text = format
    }

     fun update2(showDate2: TextView, calendar: Calendar): String {
        val format2 = SimpleDateFormat("HH:mm", Locale.US).format(calendar.time)
        showDate2.text = format2
        return format2
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun pickDate(textView: TextView, calendar: Calendar): DatePickerDialog.OnDateSetListener {
        val pickDateListen = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            update(textView, calendar)

        }
        return pickDateListen

    }

    fun pickDateListener(
        context: Context,
        datePickerDialog: DatePickerDialog.OnDateSetListener,
        calendar: Calendar
    ) {
        DatePickerDialog(
            context,
            datePickerDialog,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()

    }

    fun pickTime(textView: TextView, calendar2: Calendar): TimePickerDialog.OnTimeSetListener {
        val pickTime = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            calendar2.set(Calendar.HOUR_OF_DAY,hour)
            calendar2.set(Calendar.MINUTE,minute)
            update2(textView,calendar2)

        }

        return pickTime

    }
    fun pickTimeListener(context: Context,timePickerDialog: TimePickerDialog.OnTimeSetListener,calendar2: Calendar) {
        TimePickerDialog(context,timePickerDialog,calendar2.get(Calendar.HOUR_OF_DAY),calendar2.get(Calendar.MINUTE),false).show()
}

    @RequiresApi(Build.VERSION_CODES.O)
    fun noteSaver(context : Context,noteText: EditText,showDate2: TextView, calendar: Calendar, calendar2: Calendar) {
        var localDateTime = LocalDateTime.ofInstant(calendar.time.toInstant(), ZoneId.systemDefault())
        var localDate = localDateTime.toLocalDate()
        var format2 = update2(showDate2,calendar2)
        var database : userDatabase = userDatabase.getData(context)
        if(localDate == LocalDate.now()){
            var note = todayInfo(UUID.randomUUID().toString(),localDate.toString(),calendar2.time.hours,format2,noteText.text.toString())

            database.userDao().addNote(note)

        }
         if(localDate == LocalDate.now() || localDate.format(DateTimeFormatter.ofPattern("dd-MM-yy")) in database.userDao().getDates()) {
            var i = 0
            var j = 1

            while(i <= 6) {
                while (j <= 7){
                    val dayCount = -localDate.dayOfWeek.getLong(ChronoField.DAY_OF_WEEK)  + j
                    val day = localDate.plusDays(dayCount).dayOfWeek.toString()
                    val startOfWeek =localDate.plusDays(dayCount).format(DateTimeFormatter.ofPattern("dd-MM-yy"))

                    if(localDate.format(DateTimeFormatter.ofPattern("dd-MM-yy")) == database.userDao().getDates()[i] ) {
                        var weekObject = weeklyNote(j,startOfWeek,day,calendar2.time.hours,format2," ${noteText.text.toString()}  \n ${database.userDao().getTime()[i]} \n ${database.userDao().getNote()[i]}")
                        database.userDao().updateWeekly(weekObject)
                        i++
                        j++

                    }


                    i++
                    j++
                }


            }




        }
    }

}
