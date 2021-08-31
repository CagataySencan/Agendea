package com.cagataysencan.agendea.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cagataysencan.agendea.data.monthlyNote
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.weeklyNote

class monthlyFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var database : userDatabase = userDatabase.getData(application)
    val monthlyyNotes : LiveData<List<monthlyNote>> = database.userDao().readMonthlyNote()

}