package com.cagataysencan.agendea.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cagataysencan.agendea.R
import kotlinx.android.synthetic.main.fragment_calendar.*


class calendarFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todayFragment = todayFragment()
        val weeklyFragment = weeklyFragment()
        val monthlyFragment = monthlyFragment()
        top_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.today ->  fragmentChanger(todayFragment)
                R.id.weekly -> fragmentChanger(weeklyFragment)
                R.id.monthly -> fragmentChanger(monthlyFragment)
            }
            true
        }

    }
    fun fragmentChanger(fragment : Fragment) {
        var transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout2,fragment)
        transaction.commit()
    }

}