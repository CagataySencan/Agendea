package com.cagataysencan.agendea.viewModels

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.text.TextUtils.replace
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.AndroidViewModel
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.models.userInfo
import com.cagataysencan.agendea.views.MainActivity
import com.cagataysencan.agendea.views.fragmentBase

class mainViewModel(application: Application) : AndroidViewModel(application) {

    fun firstTimeControl(context: Context) {
        var sharedPreferences =
            context.getSharedPreferences("prefs", AppCompatActivity.MODE_PRIVATE)
        var firstStart = sharedPreferences.getBoolean("firstStart", true)
        if (firstStart) {
            var intent = Intent(context, fragmentBase::class.java)
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
            var sharedPreferences =
                context.getSharedPreferences("prefs", AppCompatActivity.MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            editor.putBoolean("firstStart", false)
            editor.apply()

        } else {
            var database: userDatabase = userDatabase.getData(context as MainActivity)

            var list: List<userInfo> = database.userDao().readData()
            var name = list[0].name

            Toast.makeText(context as MainActivity, "Welcome to Agendea $name !", Toast.LENGTH_LONG)
                .show()
        }
    }

    fun fragmentChanger(fragment: Fragment, context: Context)   {
        var transaction = (context as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()
        }


    }
