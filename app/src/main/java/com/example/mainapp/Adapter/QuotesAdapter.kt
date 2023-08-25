package com.example.mainapp.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainapp.R
import com.example.mainapp.Model.Result

class QuotesAdapter(private var listItems: List<Result>, private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {
    interface ItemClickListener {
        fun onItemClickListener(clickItem: Result)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName: TextView
        var companyName: TextView
        var layout1: LinearLayout

        init {
            itemView.apply {
                countryName = findViewById(R.id.Mfr_Name)
                companyName = findViewById(R.id.Country)
                layout1 = findViewById(R.id.Layout1)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(inflatedLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listItems[position]
        holder.apply {
            countryName.text = data.Country
            companyName.text = data.Mfr_Name
            layout1.setOnClickListener {
                itemClickListener.onItemClickListener(data)
            }
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}
