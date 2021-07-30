package com.cagataysencan.agendea.views

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.LocaleData
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.viewModels.addNoteViewModel
import kotlinx.android.synthetic.main.fragment_add_note.*
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


class addNoteFragment : Fragment() {
    private lateinit var addNoteView : addNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNoteView = ViewModelProvider(this).get(addNoteViewModel::class.java)
        val calendar = Calendar.getInstance()
        val calendar2 = Calendar.getInstance()
        val pickDate = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)

            update(calendar)
            var localDateTime = LocalDateTime.ofInstant(calendar.time.toInstant(), ZoneId.systemDefault())
            var localDate = localDateTime.toLocalDate()



        }
        val pickTime = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            calendar2.set(Calendar.HOUR_OF_DAY,hour)
            calendar2.set(Calendar.MINUTE,minute)
            update2(calendar2)
        }

        datePicker.setOnClickListener {
            DatePickerDialog(this.requireContext(),pickDate,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()



        }
        timePicker.setOnClickListener {
            TimePickerDialog(this.requireContext(),pickTime,calendar2.get(Calendar.HOUR_OF_DAY),calendar2.get(Calendar.MINUTE),true).show()
        }

        saveNote.setOnClickListener{
            var localDateTime = LocalDateTime.ofInstant(calendar.time.toInstant(), ZoneId.systemDefault())
            var localDate = localDateTime.toLocalDate()


        }




    }

    @SuppressLint("SetTextI18n")
    fun update(calendar : Calendar)  {
        val format = SimpleDateFormat("dd-MM-yyyy",Locale.US).format(calendar.time)
        showDate.text = format




    }
    fun update2(calendar : Calendar)  {
        val format2 = SimpleDateFormat("HH:mm",Locale.US).format(calendar.time)
        showDate2.text = format2

    }


}