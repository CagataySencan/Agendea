package com.cagataysencan.agendea.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.data.userDatabase
import com.cagataysencan.agendea.data.noteInfo
import kotlinx.android.synthetic.main.recycler_row.view.*

class recyclerAdapter(val list : List<noteInfo>, val context: Context) : RecyclerView.Adapter<recyclerAdapter.viewHolder>() {
    class viewHolder(view : View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.recycler_row,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var database: userDatabase = userDatabase.getData(context)
        holder.itemView.date.text = list[position].exactTime
        holder.itemView.note.text = list[position].note
        holder.itemView.deleteButton.setOnClickListener {

            database.userDao().deleteNote(list[position])
        }


    }

    override fun getItemCount(): Int {
        return list.size

    }


}