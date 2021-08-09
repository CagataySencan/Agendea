package com.cagataysencan.agendea.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.apiService.cryptoModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.finance_recycler_row.view.*

class financeRecyclerAdapter(var cryptoModel: ArrayList<cryptoModel>) : RecyclerView.Adapter<financeRecyclerAdapter.viewHolder>() {

    class viewHolder(view : View) :  RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflator  = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.finance_recycler_row,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.itemView.coinPrice.text = "${cryptoModel[position].symbol}"
        holder.itemView.todayHigh.text = "Price : ${cryptoModel[position].price} USDT"
        holder.itemView.todayLow.text = "24H High : ${cryptoModel[position].high} USDT"
        holder.itemView.coinVolume.text = "24H Price Change : %${cryptoModel[position].d.priceChangePct}"
        holder.itemView.usdtVolume.text = "24H Volume ${cryptoModel[position].d.volume}"
        var imageUrl = cryptoModel[position].logoUrl
        Picasso.get().load(imageUrl).into(holder.itemView.cryptoImage)

    }

    override fun getItemCount(): Int {
        return cryptoModel.size
    }

}