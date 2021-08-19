package com.cagataysencan.agendea.views

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.viewModels.addNoteViewModel
import kotlinx.android.synthetic.main.fragment_add_note.*
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

        addNoteView.pickDate(showDate,calendar)
        addNoteView.pickTime(showDate2,calendar2)

        val pickDate = addNoteView.pickDate(showDate,calendar)
        val pickTime = addNoteView.pickTime(showDate2,calendar2)


        datePicker.setOnClickListener {
           addNoteView.pickDateListener(this.requireContext(),pickDate,calendar)
        }
        timePicker.setOnClickListener {
            addNoteView.pickTimeListener(this.requireContext(),pickTime,calendar2)
        }

        saveNote.setOnClickListener{
            addNoteView.noteSaver(this.requireContext(),noteText,showDate2,calendar,calendar2)
            addNoteView.fragmentChanger(calendarFragment(),this.requireContext())


        }

    }






}