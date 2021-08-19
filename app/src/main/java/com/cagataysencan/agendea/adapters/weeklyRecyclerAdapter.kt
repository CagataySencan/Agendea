package com.cagataysencan.agendea.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.weeklyNote
import kotlinx.android.synthetic.main.recycler_row_weekly.view.*

class weeklyRecyclerAdapter(private var weeklyNote: List<weeklyNote>, var context : Context) : RecyclerView.Adapter<weeklyRecyclerAdapter.viewHolder>() {
    class viewHolder(view : View) :  RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflator  = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.recycler_row_weekly,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var database: userDatabase = userDatabase.getData(context)
        holder.itemView.weekDate.text = weeklyNote[position].date
        holder.itemView.weekDay.text = weeklyNote[position].day
        holder.itemView.noteWeek.text = weeklyNote[position].note
        holder.itemView.hourWeek.text = weeklyNote[position].exactTime
        holder.itemView.deleteWeek.setOnClickListener {
            weeklyNote[position].note = ""
            weeklyNote[position].exactTime = ""
            database.userDao().deleteWeeklyNote(weeklyNote[position])

        }

    }

    override fun getItemCount(): Int {
       return weeklyNote.size
    }
}