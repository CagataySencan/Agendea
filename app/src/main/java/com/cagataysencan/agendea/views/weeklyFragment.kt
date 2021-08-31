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
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.weeklyNote
import com.cagataysencan.agendea.viewModels.weeklyFragmentViewModel
import kotlinx.android.synthetic.main.fragment_weekly.*
import kotlin.collections.ArrayList


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
        var database : userDatabase = userDatabase.getData(this.requireContext())

        var i = 1
        var j = 0
        var emptyList = ArrayList<weeklyNote>()

        while(i != 8) {
            if(database.userDao().checkTable() < 7 ) {
                weeklyView.printWeek(this.requireContext(),i,emptyList,i,"","")
                weeklyView.weeklyNotes.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                    weeklyAdapter = weeklyRecyclerAdapter(it,this.requireContext())
                    recyclerViewWeekly.adapter = weeklyAdapter

                })
                i++
                j++

            }

            else {
                weeklyView.printWeek(this.requireContext(),i,emptyList,i,database.userDao().getNote()[j],database.userDao().getTime()[j])
                weeklyView.weeklyNotes.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                    weeklyAdapter = weeklyRecyclerAdapter(it,this.requireContext())
                    recyclerViewWeekly.adapter = weeklyAdapter

                })
                i++
                j++

            }


        }



    }

}