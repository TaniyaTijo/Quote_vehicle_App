//package com.example.mainapp
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class VehicleAdapter(var vehicleList: List<VehicleType>):RecyclerView.Adapter<VehicleAdapter.ViewHolder>() {
//    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
//
//        var name: ImageView = view.findViewById(R.id.Name)
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//        val layoutView =
//            LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
//        return ViewHolder(layoutView)
//    }
//
//    override fun getItemCount(): Int {
//        return vehicleList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        var data = vehicleList[position]
//        holder.name.text=data.Name
//    }
//
//}
package com.example.mainapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehicleAdapter(private val vehicleList: List<VehicleType>) :
    RecyclerView.Adapter<VehicleAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.Name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return ViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = vehicleList[position]
        holder.name.text = data.Name
    }
}
