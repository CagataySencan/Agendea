package com.cagataysencan.agendea.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.data.monthlyNote
import com.cagataysencan.agendea.data.todayInfo
import com.cagataysencan.agendea.data.userDatabase
import kotlinx.android.synthetic.main.recycler_row_monthly.view.*

class monthlyRecyclerAdapter(val list : List<String>, val context: Context) : RecyclerView.Adapter<monthlyRecyclerAdapter.viewHolder>() {
    class viewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.recycler_row_monthly,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var database = userDatabase.getData(context)
        holder.itemView.month.text = list[position]
        holder.itemView.month.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}