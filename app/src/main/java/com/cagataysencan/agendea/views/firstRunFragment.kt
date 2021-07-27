package com.cagataysencan.agendea.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.models.userInfo
import com.cagataysencan.agendea.viewModels.firstRunViewModel
import kotlinx.android.synthetic.main.fragment_first_run.*


class firstRunFragment : Fragment() {
    lateinit var viewModelFirstRun : firstRunViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFirstRun = ViewModelProvider(this).get(firstRunViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first_run, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save.setOnClickListener {
            val name = username.text.toString()
            val age = age.text.toString()
            val city = city.text.toString()
            val user = userInfo(0,name,age,city)
            viewModelFirstRun.firstRun(user,context?.applicationContext)

        }

    }
}