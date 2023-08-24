package com.example.mainapp.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainapp.R
import com.example.mainapp.Model.Result

class QAdapter(var listItems: List<Result>,val itemClickListener: ItemClickListener) : RecyclerView.Adapter<QAdapter.ViewHolder>() {
    interface ItemClickListener{
        fun OnItemClickListener(clickItem: Result)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName = itemView.findViewById<TextView>(R.id.Mfr_Name)
        var companyName = itemView.findViewById<TextView>(R.id.Country)
        var layout1 = itemView.findViewById<LinearLayout>(R.id.Layout1)
        init{
            layout1.setOnClickListener{
                val clickItem =listItems[adapterPosition]
                itemClickListener.OnItemClickListener(clickItem)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(inflatedLayout)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listItems[position]
        holder.countryName.text = data.Country
        holder.companyName.text = data.Mfr_Name
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}