package com.cagataysencan.agendea.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.data.weeklyNote
import kotlinx.android.synthetic.main.recycler_row_weekly.view.*

class weeklyRecyclerAdapter(private var weeklyNote: ArrayList<weeklyNote>) : RecyclerView.Adapter<weeklyRecyclerAdapter.viewHolder>() {
    class viewHolder(view : View) :  RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflator  = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.recycler_row_weekly,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.weekDate.text = weeklyNote[position].date
        holder.itemView.weekDay.text = weeklyNote[position].day
        holder.itemView.noteWeek.text = weeklyNote[position].note
    }

    override fun getItemCount(): Int {
       return weeklyNote.size
    }
}