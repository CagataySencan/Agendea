package com.cagataysencan.agendea.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.viewModels.recyclerAdapter
import kotlinx.android.synthetic.main.fragment_today.*


class todayFragment : Fragment() {
    lateinit var recyclerAdapter : recyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context?.applicationContext!!)
        recycler_view.layoutManager = layoutManager
        recyclerAdapter = recyclerAdapter("14:00","31 zamanı")
        recycler_view.adapter = recyclerAdapter
    }


}