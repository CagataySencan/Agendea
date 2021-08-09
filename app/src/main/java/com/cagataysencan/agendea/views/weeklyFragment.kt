package com.cagataysencan.agendea.views

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.adapters.weeklyRecyclerAdapter
import com.cagataysencan.agendea.data.noteInfo
import com.cagataysencan.agendea.data.weeklyNote
import com.cagataysencan.agendea.viewModels.weeklyFragmentViewModel
import kotlinx.android.synthetic.main.fragment_weekly.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.temporal.ChronoField


class weeklyFragment : Fragment() {
    private lateinit var weeklyView : weeklyFragmentViewModel
    private lateinit var weeklyAdapter : weeklyRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_weekly, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewWeekly.layoutManager = LinearLayoutManager(this.requireContext())


        weeklyView = ViewModelProvider(this).get(weeklyFragmentViewModel::class.java)
        val currentDate = LocalDate.now()
        var i = -1
        var emptyList = ArrayList<weeklyNote>()

        while(i != 6) {

            val dayCount = currentDate.dayOfWeek.getLong(ChronoField.DAY_OF_WEEK) + i
            val day = currentDate.plusDays(dayCount).dayOfWeek
            val startOfWeek =currentDate.plusDays(dayCount).format(DateTimeFormatter.ofPattern("dd-MM-yy"))
            emptyList.add(weeklyNote(startOfWeek,day.toString(),"asldkmas"))
            weeklyAdapter = weeklyRecyclerAdapter(emptyList)
            recyclerViewWeekly.adapter = weeklyAdapter
            i++

        }



    }

}