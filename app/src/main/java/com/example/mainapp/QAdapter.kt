package com.example.mainapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class QAdapter(var listItems: List<Result>) : RecyclerView.Adapter<QAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName = itemView.findViewById<TextView>(R.id.Country)
        var companyName = itemView.findViewById<TextView>(R.id.MfrName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QAdapter.ViewHolder {
        var inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(inflatedLayout)
    }

    override fun onBindViewHolder(holder: QAdapter.ViewHolder, position: Int) {
        var data = listItems[position]
        holder.countryName.text = data.Country
        holder.companyName.text = data.Mfr_Name
    }

    override fun getItemCount(): Int {
        return listItems.size
    }


}