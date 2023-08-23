package com.example.mainapp.Adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.mainapp.R
import com.example.mainapp.Model.Result
import com.example.mainapp.Model.Vehicle
import com.example.mainapp.Model.VehicleType


class QAdapter(var listItems: List<Result>,val itemClickListener: ItemClickListener) : RecyclerView.Adapter<QAdapter.ViewHolder>() {
    interface ItemClickListener{
        fun OnItemClickListener(clickItem: Result)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName = itemView.findViewById<TextView>(R.id.Country)
        var companyName = itemView.findViewById<TextView>(R.id.MfrName)
        var layout1 = itemView.findViewById<LinearLayout>(R.id.Layout1)
        init{
            layout1.setOnClickListener{
                val clickItem =listItems[adapterPosition]
                itemClickListener.OnItemClickListener(clickItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(inflatedLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = listItems[position]
        holder.countryName.text = data.Country
        holder.companyName.text = data.Mfr_Name

    }

    override fun getItemCount(): Int {
        return listItems.size
    }


}