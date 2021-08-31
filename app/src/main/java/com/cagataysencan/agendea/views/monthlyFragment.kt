package com.cagataysencan.agendea.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.adapters.monthlyRecyclerAdapter
import com.cagataysencan.agendea.adapters.weeklyRecyclerAdapter
import com.cagataysencan.agendea.viewModels.monthlyFragmentViewModel
import kotlinx.android.synthetic.main.fragment_monthly.*
import kotlinx.android.synthetic.main.fragment_weekly.*


class monthlyFragment : Fragment() {
    private lateinit var monthlyViewModel  : monthlyFragmentViewModel
    private lateinit var monthlyAdapter : monthlyRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_monthly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        monthlyViewModel = ViewModelProvider(this).get(monthlyFragmentViewModel::class.java)
        recyclerViewMonthly.layoutManager = LinearLayoutManager(this.requireContext())
    }


}