package com.cagataysencan.agendea.viewModels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.cagataysencan.agendea.R
import java.util.zip.Inflater

class recyclerAdapter(val date : String, val note : String) : RecyclerView.Adapter<recyclerAdapter.viewHolder>() {
    class viewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.recycler_row,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return date.length

    }
}