package com.cagataysencan.agendea.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        val noteFragment = noteFragment()


        viewModelMainActivity.fragmentChanger(calendarFragment,this)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.calendar ->  viewModelMainActivity.fragmentChanger(calendarFragment,this)
                R.id.finance ->  viewModelMainActivity.fragmentChanger(financeFragment,this)
                R.id.profile ->  viewModelMainActivity.fragmentChanger(noteFragment,this)
            }
            true
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflator = menuInflater
        menuInflator.inflate(R.menu.create_note_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val addNoteFragment = addNoteFragment()

        if(item.itemId == R.id.newNote) {
            viewModelMainActivity.fragmentChanger(addNoteFragment,this)

        }
        return super.onOptionsItemSelected(item)
    }


}