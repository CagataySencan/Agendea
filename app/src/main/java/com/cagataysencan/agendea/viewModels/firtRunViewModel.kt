package com.cagataysencan.agendea.viewModels

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.lifecycle.AndroidViewModel
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.userInfo
import com.cagataysencan.agendea.views.MainActivity


class firstRunViewModel(application: Application) : AndroidViewModel(application) {


    fun firstRun(user : userInfo, context: Context?){
        var database : userDatabase = userDatabase.getData(context!!)
        database.userDao().addUser(user)


        var intent = Intent(context, MainActivity::class.java)
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intent)
    }
}