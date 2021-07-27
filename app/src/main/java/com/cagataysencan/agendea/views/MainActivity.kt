package com.cagataysencan.agendea.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.viewModels.mainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewModelMainActivity: mainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelMainActivity = ViewModelProvider(this).get(mainViewModel::class.java)
        viewModelMainActivity.firstTimeControl(this)
        val calendarFragment = calendarFragment()
        val financeFragment = financeFragment()
        val profileFragment = profileFragment()

        viewModelMainActivity.fragmentChanger(calendarFragment,this)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.calendar ->  viewModelMainActivity.fragmentChanger(calendarFragment,this)
                R.id.finance ->  viewModelMainActivity.fragmentChanger(financeFragment,this)
                R.id.profile ->  viewModelMainActivity.fragmentChanger(profileFragment,this)
            }
            true
        }

    }


}