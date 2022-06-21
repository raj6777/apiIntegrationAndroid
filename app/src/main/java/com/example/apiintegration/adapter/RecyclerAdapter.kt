package com.example.apiintegration.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apiintegration.R
import com.example.apiintegration.models.DataModel

class RecyclerAdapter(private val dataList: List<DataModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recyclerModel = dataList[position]

        // Text set to the TextView widget
        holder.quoteText.text = recyclerModel.quote
        holder.author.text = recyclerModel.author
        holder.series.text = recyclerModel.series

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val quoteText: TextView = itemView.findViewById(R.id.quoteText)
        val author: TextView = itemView.findViewById(R.id.quoteAuthor)
        val series: TextView = itemView.findViewById(R.id.quoteSeries)

    }



}

