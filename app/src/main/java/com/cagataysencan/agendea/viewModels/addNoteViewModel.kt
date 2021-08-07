package com.cagataysencan.agendea.viewModels

import android.app.Application
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.noteInfo
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class addNoteViewModel(application: Application) : AndroidViewModel(application) {
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
        if(localDate == LocalDate.now()){
            var note = noteInfo(UUID.randomUUID().toString(),localDate.toString(),calendar2.time.hours,format2,noteText.text.toString())
            var database : userDatabase = userDatabase.getData(context)
            database.userDao().addNote(note)

        }
    }

}
